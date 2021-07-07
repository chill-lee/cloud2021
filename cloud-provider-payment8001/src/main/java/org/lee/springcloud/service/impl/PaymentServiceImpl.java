package org.lee.springcloud.service.impl;

import org.lee.springcloud.dao.PaymentDao;
import org.lee.springcloud.entities.Payment;
import org.lee.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chill
 * @date 2021年07月05日 16:38
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
