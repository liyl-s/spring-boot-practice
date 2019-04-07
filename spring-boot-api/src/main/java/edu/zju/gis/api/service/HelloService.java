package edu.zju.gis.api.service;

import edu.zju.gis.data.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanlong_lee@qq.com
 * @version 1.0 2019/04/04
 */
@RequestMapping("refactor")
public interface HelloService {
    @GetMapping("/hello4")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello6")
    String hello(@RequestBody User user);
}
