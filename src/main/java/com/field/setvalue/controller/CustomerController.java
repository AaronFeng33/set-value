package com.field.setvalue.controller;

import com.field.setvalue.model.Customer;
import com.field.setvalue.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 消费者controller
 *
 * @author FengChuan
 * @since 2020-08-19 16:29:37
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    /**
     * 获取消费者信息
     *
     * @param customerId 消费者ID
     * @return Customer 消费者信息
     * @author FengChuan
     * @since 2020-08-19 16:33:31
     */
    @GetMapping("/get_customer")
    public Customer getCustomer(String customerId) {
        return customerService.getCustomer(customerId);
    }
}
