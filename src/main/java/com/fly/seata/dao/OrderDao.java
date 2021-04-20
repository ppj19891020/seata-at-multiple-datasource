package com.fly.seata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fly.seata.common.order.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HelloWood
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {

    /**
     * 插入订单
     * @param order
     */
    @Insert({"INSERT INTO `order`(`user_id`, `product_id`, `count`, `money`) VALUES (#{userId},#{productId},#{count},#{money})"})
    int insertOrder(Order order);



}
