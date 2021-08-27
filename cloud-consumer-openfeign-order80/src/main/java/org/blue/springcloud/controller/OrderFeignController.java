package org.blue.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.blue.springcloud.entities.CommonResult;
import org.blue.springcloud.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blue
 * @date 2021/8/24 17:25
 */
@RestController
@Log4j2
@RequestMapping(value = "/consumer")
public class OrderFeignController {

    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/select{id}")
    public CommonResult selectPayment(@PathVariable("id") Long id){
        return orderFeignService.selectPayment(id);
    }

}
