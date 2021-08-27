package org.blue.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.blue.springcloud.entities.Payment;
import org.blue.springcloud.service.PaymentService;
import org.blue.springcloud.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService{

}




