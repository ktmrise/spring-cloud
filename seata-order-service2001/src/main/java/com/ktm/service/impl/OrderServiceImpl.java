package com.ktm.service.impl;

import com.ktm.dao.OrderDao;
import com.ktm.entity.Order;
import com.ktm.service.AccountService;
import com.ktm.service.OrderService;
import com.ktm.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Resource
    private OrderDao orderDao;


    @Resource
    private AccountService accountService;


    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
        log.info("------》开始新建订单");
        orderDao.create(order);

        log.info("------->订单微服务开始调用库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("---->订单微服务开始调用库存，做扣减end");

        log.info("---->订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---->订单微服务开始调用账户，做扣减end");

        //修改订单状态
        log.info("------>修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("------>修改订单状态结束");

        log.info("下订单结束了-------------");
    }
}
