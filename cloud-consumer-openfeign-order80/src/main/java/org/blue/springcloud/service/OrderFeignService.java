package org.blue.springcloud.service;

import org.blue.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author blue
 * @date 2021/8/24 17:17
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderFeignService {

    @RequestMapping("/payment/select{id}")
    CommonResult selectPayment(@PathVariable(value = "id") Long id);

}
