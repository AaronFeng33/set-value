package com.field.setvalue.service;

import com.field.setvalue.dao.CustomerDao;
import com.field.setvalue.model.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 消费者服务
 *
 * @author FengChuan
 * @since 2020-08-19 16:30:54
 */
@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    /**
     * 获取消费者信息
     *
     * @param customerId 消费者ID
     * @return Customer 消费者信息
     * @author FengChuan
     * @since 2020-08-19 16:33:31
     */
    public Customer getCustomer(String customerId) {
        return customerDao.getCustomer(customerId);
    }
}
