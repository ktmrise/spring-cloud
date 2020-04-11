package com.ktm.springcloud.service.impl;

import com.ktm.springcloud.dao.PaymentDao;
import com.ktm.springcloud.entity.Payment;
import com.ktm.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @Author: rise
 * @create: 2020-04-11 10:13
 **/

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
