package com.field.setvalue.service;

import com.field.setvalue.annotation.MethodNeedSetValue;
import com.field.setvalue.dao.OrderDao;
import com.field.setvalue.model.ResultVO;
import com.field.setvalue.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务
 *
 * @author FengChuan
 * @since 2020-08-19 16:31:10
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    /**
     * 获取订单信息 - 集合
     *
     * @return Order 订单信息
     * @author FengChuan
     * @since 2020-08-19 16:55:03
     */
    @MethodNeedSetValue
    public List<Order> getOrder() {
        return orderDao.getOrder();
    }

    /**
     * 获取订单列表 - 封装对象
     *
     * @author FengChuan
     * @since 2020-08-20 09:56:46
     */
    @MethodNeedSetValue
    public ResultVO<Order> getOrderList() {
        ResultVO<Order> result = new ResultVO<>();
        result.setOrderList(orderDao.getOrder());
        return result;
    }
}
