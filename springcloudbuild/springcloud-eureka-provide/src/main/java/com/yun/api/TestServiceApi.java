package com.yun.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "provide-service", contextId = "TestServiceApi")
public interface TestServiceApi {

    @RequestMapping("/test/init")
    String get(String name);;
}
