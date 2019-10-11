package com.tomalen.springlanuch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tomalen.springlanuch.Mapper")
public class SpringLanuchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLanuchApplication.class, args);
    }

}
