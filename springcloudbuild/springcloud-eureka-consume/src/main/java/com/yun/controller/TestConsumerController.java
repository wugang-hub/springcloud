package com.yun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer1")
    public String consumerTest1(String param){
        String obj = new RestTemplate().getForObject("http://localhost:8701/test/init?param="+param, String.class);
        return obj;
    }

    @GetMapping("/consumer2")
    public String consumerTest2(String param){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provide");
        String obj = new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/test/init?param="+param, String.class);

        return obj;
    }

    @GetMapping("/consumer3")
    public String consumerTest3(String param){
        String obj = restTemplate.getForObject("http://eureka-provide/test/init?param="+param, String.class);
        return obj;
    }

}
