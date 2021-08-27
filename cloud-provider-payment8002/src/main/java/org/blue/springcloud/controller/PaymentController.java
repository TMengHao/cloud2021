package org.blue.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.blue.springcloud.entities.CommonResult;
import org.blue.springcloud.entities.Payment;
import org.blue.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author blue
 * @date 2021/8/19
 */
@RestController
@Log4j2
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        log.info("保存支付信息为:{}",payment);
        if(paymentService.save(payment)){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,payment.getId());
        }else{
            return new CommonResult(444,"插入数据失败");
        }
    }

    @GetMapping(value = "/select{id}")
    public CommonResult selectPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        if(payment != null){
            return new CommonResult(200,"查询数据成功,serverPort："+serverPort,payment);
        }else{
            return new CommonResult(444,"查询数据失败");
        }
    }

}
