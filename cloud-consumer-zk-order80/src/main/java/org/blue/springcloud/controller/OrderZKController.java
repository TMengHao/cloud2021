package org.blue.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author blue
 * @date 2021/8/23 15:28
 */
@RestController
@Log4j2
@RequestMapping("/consumer")
public class OrderZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment/payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/zk",String.class);
    }

}
