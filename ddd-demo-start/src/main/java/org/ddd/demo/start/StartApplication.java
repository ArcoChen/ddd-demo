package org.ddd.demo.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author huangjiachang
 */
@SpringBootApplication
@ComponentScan(basePackages = {"${spirng.extra-component-scan}"})
@MapperScan(basePackages = "org.ddd.demo.*.infrastructure.*",
        sqlSessionFactoryRef = "configSqlSessionFactory")
@EnableTransactionManagement
@EnableAsync
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
