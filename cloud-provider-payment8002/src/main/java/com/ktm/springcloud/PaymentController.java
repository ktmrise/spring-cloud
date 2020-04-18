package com.ktm.springcloud;

import com.ktm.springcloud.entity.CommonResult;
import com.ktm.springcloud.entity.Payment;
import com.ktm.springcloud.service.PaymentService;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @description:
 * @Author: rise
 * @create: 2020-04-11 10:18
 **/

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;





    @PostMapping({"/","/payment/create"})
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*************插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败"+serverPort, null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*************查询结果：" + payment);

        if (payment!=null) {
            return new CommonResult(200, "查询成功"+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
