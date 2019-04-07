package edu.zju.gis.hello.controller;

import edu.zju.gis.data.model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @author yanlong_lee@qq.com
 * @version 1.0 2019/04/03
 */
@Log
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("hello")
    public String index() throws InterruptedException {
        List<String> services = client.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = client.getInstances(service);
            instances.forEach(inst -> log.info("/hello, host:" + inst.getHost() + ", service_id:" + inst.getServiceId()));
        }
        int sleepTime = new Random().nextInt(3000);
        log.info("sleepTime: " + sleepTime);
        Thread.sleep(sleepTime);
        return "Hello World!";
    }

    @GetMapping("hello1")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping("hello3")
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
