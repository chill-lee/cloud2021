package org.lee.springcloud.service;

import org.lee.springcloud.entities.CommonResult;
import org.lee.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chill
 * @date 2021年07月22日 11:26
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 简单查询
     *
     * @param id 查询id
     * @return org.lee.springcloud.entities.CommonResult<org.lee.springcloud.entities.Payment>
     * @author chill
     * @date 2021/7/22 11:32
     */
    @GetMapping(value = "payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 超时3秒测试
     * @return java.lang.String
     * @author chill
     * @date 2021/7/22 11:53
     */
    @GetMapping(value = "payment/feign/timeout")
    String paymentFeignTimeout();
}
