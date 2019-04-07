package edu.zju.gis.feign.service;

import edu.zju.gis.api.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author yanlong_lee@qq.com
 * @version 1.0 2019/04/04
 */
@FeignClient("service-hello")
public interface RefactorHelloService extends HelloService {
}
