package com.guozhaotong;

import com.alibaba.fastjson.JSON;

public class Guo {
    public String outputPerson() {
        Person person = new Person("Guo", 24, "She is a girl.");
        return JSON.toJSONString(person);
    }
}
