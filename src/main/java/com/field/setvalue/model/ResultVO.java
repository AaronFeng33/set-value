package com.field.setvalue.model;

import com.field.setvalue.annotation.ResultListName;
import lombok.Data;

import java.util.List;

/**
 * 返回封装对象
 *
 * @author FengChuan
 * @since 2020-08-20 09:50:48
 */
@Data
@ResultListName(collectionName = "orderList")
public class ResultVO<E> {
    public List<E> orderList;
}
