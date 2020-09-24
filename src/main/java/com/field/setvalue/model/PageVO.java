package com.field.setvalue.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


/**
 * 标准列表返回VO
 *
 * @author FengChuan
 * @since 2020-09-24 14:07:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class PageVO<T> extends PageInfo implements Serializable {

    private static final long serialVersionUID = -6868692026104831795L;

    private long total;

    private List<T> list;

    public PageVO(long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public PageVO(long current, long size, long total, List<T> list) {
        super(current, size);
        this.total = total;
        this.list = list;
    }
}
