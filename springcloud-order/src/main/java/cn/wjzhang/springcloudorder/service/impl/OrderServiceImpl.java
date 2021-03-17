package cn.wjzhang.springcloudorder.service.impl;

import cn.wjzhang.springcloudorder.feign.IntegralFeignClient;
import cn.wjzhang.springcloudorder.feign.PayFeignClient;
import cn.wjzhang.springcloudorder.feign.StockFeignClient;
import cn.wjzhang.springcloudorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    StockFeignClient stockFeignClient;

    @Autowired
    PayFeignClient payFeignClient;

    @Autowired
    IntegralFeignClient integralFeignClient;

    @Override
    public String shopping(String goods) {
        //下单
        System.out.println("订单保存完成！");
        //付款
        String r1 = payFeignClient.savePay(goods);
        //减少库存
        String r2 = stockFeignClient.saveStock(goods);
        //新增积分
        String r3 = integralFeignClient.saveIntegral(goods);
        return "订单保存完成！==>"+r1+"==>"+r2+"==>"+r3+"==>下单完成!";
    }
}