package edu.zju.gis.feign.service;

import edu.zju.gis.data.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanlong_lee@qq.com
 * @version 1.0 2019/04/03
 */
@FeignClient("service-hello")
public interface HelloService {
    @RequestMapping("hello")
    String hello();

    @GetMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello3")
    String hello(@RequestBody User name);
}
