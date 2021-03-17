package cn.wjzhang.springcloudorder.controller;

import cn.wjzhang.springcloudorder.feign.StockFeignClient;
import cn.wjzhang.springcloudorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    StockFeignClient stockFeignClient;

    @GetMapping("/shopping")
    public String shopping(@RequestParam(value = "goods") String goods){
        return orderService.shopping(goods);

    }

    @GetMapping("/test")
    public String test(){
        return "success";

    }

    @GetMapping("/testFeign")
    public String testFeign(){
        return stockFeignClient.saveStock("手机");

    }
}