package edu.zju.gis.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author yanlong_lee@qq.com
 * @version 1.0 2019/04/03
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello", String.class).getBody();
    }

    public String helloFallback() {
        return "error";
    }
}
