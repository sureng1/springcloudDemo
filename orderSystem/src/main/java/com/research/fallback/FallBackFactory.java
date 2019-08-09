package com.research.fallback;

import com.research.feign.ItemFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FallBackFactory implements FallbackFactory<ItemFeignClient> {
    private ItemServiceFallback itemServiceFallback;
    public FallBackFactory(ItemServiceFallback itemServiceFallback){
        this.itemServiceFallback = itemServiceFallback;
    }

    @Override
    public ItemFeignClient create(Throwable throwable) {
        throwable.printStackTrace();
        return itemServiceFallback;
    }
}
