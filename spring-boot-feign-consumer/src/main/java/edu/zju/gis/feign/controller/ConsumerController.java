package edu.zju.gis.feign.controller;

import edu.zju.gis.data.model.User;
import edu.zju.gis.feign.service.HelloService;
import edu.zju.gis.feign.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanlong_lee@qq.com
 * @version 1.0 2019/04/03
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;
    @Autowired
    private RefactorHelloService refactorHelloService;

    @GetMapping("feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }

    @GetMapping("feign-consumer2")
    public String helloConsumer2() {
        return helloService.hello() + "\n" +
                helloService.hello("DIDI") + "\n" +
                helloService.hello("DIDI", 30) + "\n" +
                helloService.hello(new User("DIDI", 40)) + "\n";
    }

    @GetMapping("feign-consumer3")
    public String helloConsumer3() {
        return refactorHelloService.hello("DIDI") + "\n" +
                refactorHelloService.hello("DIDI", 30) + "\n" +
                refactorHelloService.hello(new User("DIDI", 40)) + "\n";
    }
}
