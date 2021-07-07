package org.lee.springcloud.service;

import org.apache.ibatis.annotations.Param;
import org.lee.springcloud.entities.Payment;

/**
 * @author chill
 * @date 2021年07月05日 16:37
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
