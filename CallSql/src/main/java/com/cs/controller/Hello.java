package com.cs.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/cs")
    public String SayHello(){

        return "hello cs";
    }
}
