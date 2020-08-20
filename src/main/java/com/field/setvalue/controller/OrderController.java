package com.field.setvalue.controller;

import com.field.setvalue.model.ResultVO;
import com.field.setvalue.model.Order;
import com.field.setvalue.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单controller
 *
 * @author FengChuan
 * @since 2020-08-19 16:21:26
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 获取订单信息 - 集合
     *
     * @return Order 订单信息
     * @author FengChuan
     * @since 2020-08-19 16:53:20
     */
    @GetMapping("/get_order")
    public List<Order> getOrder() {
        return orderService.getOrder();
    }

    /**
     * 获取订单列表 - 封装对象
     *
     * @author FengChuan
     * @since 2020-08-20 09:56:46
     */
    @GetMapping("/get_order_list")
    public ResultVO<Order> getOrderList() {
        return orderService.getOrderList();
    }


}
