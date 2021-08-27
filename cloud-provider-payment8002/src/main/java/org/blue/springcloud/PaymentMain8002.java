package org.blue.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author blue
 * @date 2021/8/20 13:41
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"org.blue.springcloud.mapper"})
public class PaymentMain8002{

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }

}
