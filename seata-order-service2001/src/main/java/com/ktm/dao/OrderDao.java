package com.ktm.dao;

import com.ktm.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {

    void create(Order order);


    void update(@Param("userId") Long userId ,@Param("status") Integer status);
}
