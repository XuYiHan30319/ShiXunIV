package org.blackcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController{
    @ResponseBody//转为response格式
    @RequestMapping("/hello")
    public String hello(){
        return "Hello wolrd";
    }
}
