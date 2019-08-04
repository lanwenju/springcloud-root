package com.ls.server;

import com.ls.server.impl.HelloServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface HelloService {

    String getSayHi(String name);
    String getCurrrentName(String name);
    String getSayHiFallBack(String name);
}
