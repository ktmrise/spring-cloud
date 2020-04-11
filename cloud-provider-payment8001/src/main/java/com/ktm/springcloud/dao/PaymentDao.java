package com.ktm.springcloud.dao;

import com.ktm.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @Author: rise
 * @create: 2020-04-11 09:52
 **/

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id" ) Long id);
}
