package com.hyf.cloud.nacos.controller;

import com.hyf.cloud.nacos.service.MoneyService;
import com.hyf.cloud.nacos.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author baB_hyf
 * @date 2021/08/23
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private MoneyService moneyService;

    @RequestMapping("create")
    public boolean create(@RequestParam String userId,
                          @RequestParam String storeId,
                          @RequestParam Integer number) {
        System.out.println("order");

        BigDecimal money = getMoney(storeId, number);
        boolean success = orderService.create(userId, storeId, number);
        boolean success2 = moneyService.deduct(userId, money);
        return success && success2;
    }

    private BigDecimal getMoney(String storeId, Integer number) {
        return new BigDecimal(String.valueOf(100));
    }
}
