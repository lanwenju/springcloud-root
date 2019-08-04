package com.ls.server.impl;

import com.ls.server.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * api 服务提供中心
 */
@RestController
public class HelloServiceImpl implements HelloService {
    @Override
    @HystrixCommand(fallbackMethod = "getSayHiFallBack")
    @RequestMapping("getSayHi")
    public String getSayHi(String name) {
        System.out.println(1/0);
     return name + ",getSayHi";
    }

    @Override
    @RequestMapping("getname")
    public String getCurrrentName(String name) {
        return "getCurrrentName-->"+name;
    }

    @Override
    public String getSayHiFallBack(String name) {
        return "getSayHiFallBack error:" + name;
    }
}
