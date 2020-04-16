package com.ktm.springcloud.controller;

import com.ktm.springcloud.entity.CommonResult;
import com.ktm.springcloud.entity.Payment;
import com.ktm.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @Author: rise
 * @create: 2020-04-16 13:30
 **/

@RestController
@Slf4j
public class OrderFeignController {



    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign底层ribbon，客户端默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

}
