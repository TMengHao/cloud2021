package org.blue.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author blue
 * @date 2021/8/24 11:20
 */
@RestController
@Log4j2
@RequestMapping(value = "/consumer")
public class OrderConsulController {

    public static final String PAYMENT_URL = "http://consul-provider-payment/payment";

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consul")
    public String paymentZK(){
        return "spring-cloud-consul :" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
