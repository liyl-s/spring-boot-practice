package edu.zju.gis.hello.controller;

import edu.zju.gis.api.service.HelloService;
import edu.zju.gis.data.model.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanlong_lee@qq.com
 * @version 1.0 2019/04/04
 */
@RestController
public class RefactorHelloController implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
