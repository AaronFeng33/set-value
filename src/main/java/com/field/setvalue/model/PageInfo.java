package com.field.setvalue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分页参数
 *
 * @author FengChuan
 * @since 2020-09-24 14:05:53
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 5806478091166545721L;

    private long current = 1;

    private long size = 10;

}
