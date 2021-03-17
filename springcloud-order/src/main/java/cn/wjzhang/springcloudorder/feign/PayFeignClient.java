package cn.wjzhang.springcloudorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "springcloud-pay",fallback =PayFeignClientFallback.class )
public interface PayFeignClient {

    @RequestMapping("/savePay")
    String savePay(@RequestParam(value = "goods") String goods);
}

@Component
class PayFeignClientFallback implements PayFeignClient{
    @Override
    public String savePay(String goods) {
        return "支付服务异常了！";
    }
}
