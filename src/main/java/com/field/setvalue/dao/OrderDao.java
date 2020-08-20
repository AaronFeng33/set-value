package com.field.setvalue.dao;

import com.field.setvalue.model.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 订单dao
 *
 * @author FengChuan
 * @since 2020-08-19 16:30:23
 */
public interface OrderDao {
    /**
     * 获取订单信息
     *
     * @return Order 订单信息
     * @author FengChuan
     * @since 2020-08-19 16:55:03
     */
    @Select("select * from `order`")
    List<Order> getOrder();
}
