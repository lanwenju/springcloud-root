package hello.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("a-bootiful-api")
public interface HelloService {
    @RequestMapping("getsayhi")
    String getSayHi(@RequestParam("name") String name);
    @RequestMapping("getname")
    String getCurrrentName(@RequestParam("name") String name);
}
