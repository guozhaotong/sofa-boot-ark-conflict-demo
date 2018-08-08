package com.guozhaotong.springbootarkdemo.controller;

import com.guozhaotong.myself1module.Myself1;
import com.guozhaotong.myself2module.Myself2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/version1")
    public String version1(){
        Myself1 myself1 = new Myself1();
        return myself1.output();
    }

    @RequestMapping("/version2")
    public String version2(){
        Myself2 myself2 = new Myself2();
        return myself2.output();
    }

    @RequestMapping("/version3")
    public String version3(){
        Myself1 myself1 = new Myself1();
        Myself2 myself2 = new Myself2();
        return myself1.output() + "<br>" + myself2.output();
    }
}
