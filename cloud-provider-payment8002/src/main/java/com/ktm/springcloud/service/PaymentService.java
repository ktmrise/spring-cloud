package com.ktm.springcloud.service;

import com.ktm.springcloud.entity.Payment;

/**
 * @description:
 * @Author: rise
 * @create: 2020-04-11 10:13
 **/


public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById( Long id);
}
