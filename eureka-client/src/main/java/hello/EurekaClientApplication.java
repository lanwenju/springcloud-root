package hello;

import hello.server.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }

    @RestController
    class ServiceInstanceRestController{
        @Autowired
        private DiscoveryClient discoveryClient;
        @Autowired
        private HelloService helloService;
        @RequestMapping("/service-instances/{applicationName}")
        public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable("applicationName")  String applicationName){
            System.out.println("applicationName = " + applicationName);
            return discoveryClient.getInstances(applicationName);
        }

        @RequestMapping("sayhi")
        public String sayHi(){
            String s = helloService.getSayHi("张三");
            System.out.println(s);
            return s;
        }

        @RequestMapping("getname")
        public String getName(){
            String s = helloService.getCurrrentName("张三");
            System.out.println(s);
            return s;
        }
    }
}
