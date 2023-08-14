package com.ss;

import com.baomidou.mybatisplus.annotation.Version;
import com.ss.bean.Tblmanager;
import com.ss.bean.Tbltype;
import com.ss.mapper.TblmanagerMapper;
import com.ss.mapper.TbltypeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SpringLaunchTest {
    @Autowired
    TbltypeMapper tbltypeMapper;
    @Autowired
    TblmanagerMapper tblmanagerMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    @Transactional
    public void sql(){
        Tbltype tbltype = new Tbltype();
        tbltype.setParentId(61L);
        tbltype.setTypeName("trk");
        tbltype.setStatus(61L);
        int i=tbltypeMapper.insert(tbltype);

        System.out.println(i);
        //System.out.println(2/0);
     //   sql6();

    }
    @Test

    public void redisTest(){

        redisTemplate.executePipelined(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for(int i=0;i<1000;i++){

                    redisConnection.set(("Pipe"+i).getBytes(),String.valueOf(i).getBytes());
                }
                return null;
            }
        });

    }


    @Test
    //@Scheduled(cron = "6/6 0 0 0 0 0 ?")
    public void objTest() {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                Set<String> keysTmp = new HashSet<>();
                try (Cursor<byte[]> cursor = redisConnection.scan(new ScanOptions.ScanOptionsBuilder()
                        .match("*")
                        .count(1000).build())) {

                    while (cursor.hasNext()) {

                        keysTmp.add(new String(cursor.next(), "Utf-8"));
                    }

                } catch (Exception e) {

                    throw new RuntimeException(e);
                }
                System.out.println(keysTmp.toString());
                return keysTmp;
            }
        });


    }
    @Test
    public void redisconn(){
       // RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
       // RedisConnection connection = connectionFactory.getConnection();
       // System.out.println(redisTemplate.opsForValue().setIfAbsent("r", "k", 20, TimeUnit.SECONDS));
       // System.out.println(redisTemplate.getExpire("r"));
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        try{
            redisTemplate.opsForValue().setIfAbsent("a",6);
            redisTemplate.opsForValue().setIfAbsent("b",6);
            int i = 1 / 0;
            redisTemplate.exec();
            System.out.println(redisTemplate.opsForValue().get("b"));
            System.out.println("执行成功");
        }catch (Exception e){
            redisTemplate.discard();
            e.printStackTrace();
            System.out.println("执行失败");
        }

        /*
        Set<byte[]> x = connection.zRange("ran".getBytes(), 0L, 116l);
        for(byte[] ra: x){
            try {
                System.out.println(new String(ra, "Utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }



        Cursor<byte[]> scan = connection.scan(new ScanOptions.ScanOptionsBuilder()
                .match("*")
                .count(2).build());
        while (scan.hasNext()) {

            try {
                System.out.println(new String(scan.next(), "Utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }*/


    }
}
