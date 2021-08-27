package org.blue.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author blue
 * @date 2021/8/26 9:26
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfoOK(Integer id){
        return "线程池："+Thread.currentThread().getName()+",paymentInfoOK,id："+id;
    }

    public String paymentInfoTimeOut(Integer id,Integer timeout){
        try {TimeUnit.SECONDS.sleep(timeout);} catch (InterruptedException e){e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+",paymentInfoOK,id："+id+",耗时(s):"+timeout;
    }

}
