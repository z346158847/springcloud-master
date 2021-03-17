package cn.wjzhang.springcloudorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "springcloud-integral",fallback = IntegralFeignClientFallback.class)
public interface IntegralFeignClient {
    @RequestMapping("/saveIntegral")
    String saveIntegral(@RequestParam(value = "goods") String goods);
}

@Component
class IntegralFeignClientFallback implements IntegralFeignClient{
    @Override
    public String saveIntegral(String goods) {
        return "积分服务异常了！";
    }
}