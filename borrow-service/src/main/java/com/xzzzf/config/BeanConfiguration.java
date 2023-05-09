package com.xzzzf.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(value = "user-service",    // 指定服务名
        configuration = LoadBalancerConfig.class) // 指定负载均衡策略
public class BeanConfiguration {

    @Bean
    // @LoadBalanced注解表明这个restTemplate开启负载均衡的功能。
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
