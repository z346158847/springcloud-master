package cn.wjzhang.springcloudstock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @GetMapping("/saveStock")
    public String saveStock(@RequestParam String goods){
        throw new RuntimeException("服务端测试异常！");
//        return "stock1===>"+goods+"库存数-1完成！";
    }
}