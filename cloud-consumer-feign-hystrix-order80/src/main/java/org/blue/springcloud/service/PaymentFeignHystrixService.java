package org.blue.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author blue
 * @date 2021/8/27 18:12
 */
@FeignClient
public interface PaymentFeignHystrixService {
}
