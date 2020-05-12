package com.nomadicsoulmgl.nomadicsoul;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 包青格乐图
 */
@SpringBootApplication
@MapperScan("com.nomadicsoulmgl.nomadicsoul.mapper")
public class NomadicSoulApplication {

    public static void main(String[] args) {
        SpringApplication.run(NomadicSoulApplication.class, args);
    }

}
