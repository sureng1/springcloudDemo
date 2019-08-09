package com.research.feign;


import com.research.fallback.FallBackFactory;
import com.research.fallback.ItemServiceFallback;
import com.research.model.Vo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 这边feign定义好接口，底层自动绑定访问指定的微服务(app-item指定好就可以了)
 *
 *  * 申明这是一个Feign客户端，并且指明服务id
 *  * 实际开发中ItemFeignClient一般直接继承(extends)服务提供方的接口以避免代码重复（例如Item工程会以jar包的形式提供ItemService接口）
 */
@FeignClient(value = "app-item",fallback = ItemServiceFallback.class /*fallbackFactory = FallBackFactory.class*/)
public interface ItemFeignClient {
    @RequestMapping(value = "/item/{id}",method = RequestMethod.GET)
    Item queryItemById(@PathVariable("id") Long id);
}
