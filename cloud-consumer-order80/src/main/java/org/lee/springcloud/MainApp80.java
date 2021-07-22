package org.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chill
 * @date 2021年07月06日 9:07
 * //@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
 * //@LoadBalancerClient(value = "CLOUD-PAYMENT-SERVICE", configuration = CustomLoadBalancerConfiguration.class)
 */
@SpringBootApplication
@EnableEurekaClient
public class MainApp80 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp80.class, args);
    }
}
