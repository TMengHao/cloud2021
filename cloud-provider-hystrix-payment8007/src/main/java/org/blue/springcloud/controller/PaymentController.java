package org.blue.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.blue.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blue
 * @date 2021/8/26 9:48
 */
@RestController
@Log4j2
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/hystrix/ok{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        String infoOK = paymentService.paymentInfoOK(id)+",端口："+serverPort;
        return infoOK;
    }

    @GetMapping(value = "/hystrix/{timeout}timeout{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id,@PathVariable("timeout") Integer timeout){
        String infoTimeOut = paymentService.paymentInfoTimeOut(id, timeout)+",端口："+serverPort;
        return infoTimeOut;
    }
}
