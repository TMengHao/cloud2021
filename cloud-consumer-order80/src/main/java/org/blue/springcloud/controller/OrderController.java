package org.blue.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.blue.springcloud.entities.CommonResult;
import org.blue.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author blue
 * @date 2021/8/19
 */
@RestController
@RequestMapping("/consumer")
@Log4j2
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001/payment";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/create")
    public CommonResult createPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/create",payment,CommonResult.class);
    }

    @GetMapping("/select{id}")
    public CommonResult selectPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/select"+id,CommonResult.class);
    }

    @GetMapping("/entity/select{id}")
    public CommonResult selectEntityPayment(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/select" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info("{}",entity.getHeaders());
            return entity.getBody();
        }else{
            return new CommonResult(444,"访问失败");
        }
    }

}
