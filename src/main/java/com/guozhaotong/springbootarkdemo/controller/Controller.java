package com.guozhaotong.springbootarkdemo.controller;

import com.guozhaotong.arkplugin.ArkClass;
import com.guozhaotong.myself.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/test")
    public String version1() {
        Person person = new Person("Guo", 24, "Just for test.");
        ArkClass arkClass = new ArkClass();
        return arkClass.output(person);
    }
}
