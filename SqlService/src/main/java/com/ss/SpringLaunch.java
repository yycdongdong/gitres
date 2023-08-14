package com.ss;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.ss.bean.Tbltype;
import com.ss.mapper.TbltypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableFeignClients
@EnableScheduling
public class SpringLaunch {

    public static void main(String[] args) {
        SpringApplication.run(SpringLaunch.class,args);

    }
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mpi = new MybatisPlusInterceptor();
        //添加分页拦截器
        mpi.addInnerInterceptor(new PaginationInnerInterceptor());
        //添加乐观锁拦截器
        mpi.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mpi;
    }


}
