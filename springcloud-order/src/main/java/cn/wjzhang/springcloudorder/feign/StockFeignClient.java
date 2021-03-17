package cn.wjzhang.springcloudorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "springcloud-stock",fallback =StockFeignClientFallback.class )
public interface StockFeignClient {

    @RequestMapping("/saveStock")
    String saveStock(@RequestParam(value = "goods") String goods);
}

@Component
class StockFeignClientFallback implements StockFeignClient{

    @Override
    public String saveStock(String goods) {
        return "库存服务异常！";
    }
}