package com.ss.comsumer;

import org.springframework.stereotype.Component;

/*
import com.alibaba.fastjson.JSON;
import com.ss.bean.Tbltype;
import org.apache.catalina.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
*/
@Component
public class KafkaListene {
   /* @KafkaListener(topics = "hello")
    public void receive1(ConsumerRecord<String,String> record, KafkaConsumer kafkaConsumer){ //如果只接收一个值比如value，可以直接接收String value
        //ConsumerRecode 包含所有消息内容（key,value）

        System.out.println(record.key());
        System.out.println(record.value());
        record.offset();

    }

    @KafkaListener(topics = "tbltype")
    public void receive2(String value){ //如果只接收一个值比如value，可以直接接收String value
        System.out.println(value);
        Tbltype tbltype = JSON.parseObject(value, Tbltype.class);
        System.out.println(tbltype.getTypeName());

    }
*/
}
