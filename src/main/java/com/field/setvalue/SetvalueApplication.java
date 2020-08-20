package com.field.setvalue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 字段填充
 *
 * @author FengChuan
 * @since 2020-08-19 17:05:21
 */
@SpringBootApplication
@MapperScan("com.field.setvalue")
public class SetvalueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SetvalueApplication.class, args);
    }

}
