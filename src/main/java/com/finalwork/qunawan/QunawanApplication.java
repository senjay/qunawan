package com.finalwork.qunawan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.finalwork.qunawan.dao")
@SpringBootApplication
public class QunawanApplication {

    public static void main(String[] args) {
        SpringApplication.run(QunawanApplication.class, args);
    }

}
