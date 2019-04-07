package edu.zju.gis.consumer.controller;

import edu.zju.gis.consumer.service.HelloService;
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

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        return helloService.helloService();
    }
}
