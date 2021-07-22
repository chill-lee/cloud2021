package org.lee.springcloud.config;

import org.lee.myrule.CustomLoadBalancerConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chill
 * @date 2021年07月06日 9:27
 */
@Configuration
@LoadBalancerClient(value = "CLOUD-PAYMENT-SERVICE", configuration = CustomLoadBalancerConfiguration.class)
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    /**使用@LoadBalanced注解赋予RestTemplate负载均衡的能力*/
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();
    }
//    @Bean
//    @LoadBalanced
//    /**使用@LoadBalanced注解赋予RestTemplate负载均衡的能力*/
//    public RestOperations restTemplate(RestTemplateBuilder builder) {
//        return new builder.build();
//    }
}
