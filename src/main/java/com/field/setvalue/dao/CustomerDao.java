package com.field.setvalue.dao;

import com.field.setvalue.model.Customer;
import org.apache.ibatis.annotations.Select;

/**
 * 消费者dao
 *
 * @author FengChuan
 * @since 2020-08-19 16:30:10
 */
public interface CustomerDao {
    /**
     * 获取消费者信息
     *
     * @param customerId 消费者ID
     * @return Customer 消费者信息
     * @author FengChuan
     * @since 2020-08-19 16:33:31
     */
    @Select("select * from customer where customer_id = #{customer}")
    Customer getCustomer(String customerId);
}
