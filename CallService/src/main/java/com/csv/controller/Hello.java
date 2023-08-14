package com.csv.controller;


import com.alibaba.fastjson.JSONObject;
import com.csv.Service.Interfaces.CallStService;
import com.csv.bean.Tbltype;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Hello {

   /* @Autowired
    CallStService callStService;
    @RequestMapping("/csv")

    public Tbltype SayHello(){
        Tbltype tbltype = callStService.SayHello();
        System.out.println(tbltype.getGoodsTypeId());
        return callStService.SayHello();
    }*/

}
