package com.field.setvalue.model;

import com.field.setvalue.annotation.FieldNeedSetValue;
import com.field.setvalue.dao.CustomerDao;
import lombok.Data;

/**
 * 订单
 *
 * @author FengChuan
 * @since 2020-08-19 16:19:08
 */
@Data
public class Order {

    private Integer id;

    private String orderId;

    private String customerId;

    @FieldNeedSetValue(beanClass = CustomerDao.class, param = "customerId", method = "getCustomer", targetField = "customerName")
    private String name;
}
