package com.research.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.research.feign.ItemFeignClient;
import com.research.model.Vo.Item;
import com.research.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ItemFeignClient itemFeignClient;

    @Override
    @HystrixCommand(fallbackMethod = "failCallBack")
    public Item QueryItemById(Long id) {
        String url = "http://app-item/item/{id}";
        Item result =  this.restTemplate.getForObject(url,
                 Item.class,id);
        System.out.println(result);
        return result;
    }

    @Override
//    @HystrixCommand(fallbackMethod = "failCallBack")
    public Item QueryItemById2(Long id) {
        Item result =  itemFeignClient.queryItemById(id);
        System.out.println(result);
        return result;
    }

    public Item failCallBack(Long id){
        return new Item(id,"fail",null,null,null);
    }
}
