package com.research.controlller;

import com.research.model.Vo.Order;
import com.research.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "order/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") String orderId) {
        return this.orderService.queryOrderById(orderId);
    }

    @GetMapping(value = "order2/{orderId}")
    public Order queryOrderById2(@PathVariable("orderId") String orderId) {
        return this.orderService.queryOrderById2(orderId);
    }
}

