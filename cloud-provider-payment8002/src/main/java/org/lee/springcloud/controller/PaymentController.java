package org.lee.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.lee.springcloud.entities.CommonResult;
import org.lee.springcloud.entities.Payment;
import org.lee.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author chill
 * @date 2021年07月05日 16:41
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info(payment.toString());
        int result = paymentService.create(payment);
        log.info("*****插入操作返回结果:" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败,serverPort:"+serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

}
