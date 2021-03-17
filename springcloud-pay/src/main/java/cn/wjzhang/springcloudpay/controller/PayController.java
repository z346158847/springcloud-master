package cn.wjzhang.springcloudpay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @GetMapping("/savePay")
    public String saveStock(@RequestParam String goods){
        return goods+"支付完成！";
    }
}