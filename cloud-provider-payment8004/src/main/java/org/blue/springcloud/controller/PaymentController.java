package org.blue.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author blue
 * @date 2021/8/23 14:23
 */
@RestController
@Log4j2
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/zk")
    public String paymentZK(){
        return "spring-cloud-zookeeper :" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
