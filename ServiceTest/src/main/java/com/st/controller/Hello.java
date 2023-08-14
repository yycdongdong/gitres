package com.st.controller;


import com.alibaba.fastjson.JSON;
import com.common.pojo;
import com.st.bean.Tbltype;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import com.st.bean.Tbltype;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class Hello {
    @Autowired(required = false)
    private KafkaTemplate<String,String> kafkaTemplate;
    @RequestMapping("/kfk")
    public String send1(){
        /**
         * 发送消息为字符串时
         */
        ProducerRecord producerRecord=new ProducerRecord("hello","001","hello kafka+Spring001");
     kafkaTemplate.send(producerRecord);

        //   kafkaTemplate.send("hello","001","hello kafka+Spring001");
        return "send successfully!";
    }
    @RequestMapping("/kfk2")
    public String send2(){
        /**
         * 发送消息为对象时
         * 使用fastjson把对象转换为json字符串
         */
        Tbltype tbltype=new Tbltype();
        tbltype.setGoodsTypeId(19L);
        tbltype.setStatus(6L);
        tbltype.setTypeName("tbltype");
        tbltype.setParentId(6L);
        kafkaTemplate.send("tbltype","002", JSON.toJSONString(tbltype));
        return "send successfully!";
    }

}
