package cn.wjzhang.springcloudintegral.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegralController {

    @GetMapping("/saveIntegral")
    public String saveStock(@RequestParam String goods){
        return goods+"新增积分完成！";
    }

    @GetMapping("/test")
    public String test(){
        return "success";
    }
}
