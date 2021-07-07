package org.lee.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chill
 * @date 2021年07月06日 9:27
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced /**使用@LoadBalanced注解赋予RestTemplate负载均衡的能力*/
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
