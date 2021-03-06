package com.hyf.cloud.seata.controller.test.support;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 需要保证这里的路由不会注册到 RequestMappingHandlerMapping中
 *
 * @author baB_hyf
 * @date 2021/09/04
 */
@FeignClient("${spring.application.name}")
@RequestMapping("order")
public interface OrderService2 {

    @RequestMapping("delete")
    boolean delete(@RequestParam("orderId") String orderId,
                   @RequestParam(value = "ex", required = false, defaultValue = "false") Boolean throwEx);

    @RequestMapping("update")
    boolean update(@RequestParam("orderId") String orderId,
                   @RequestParam("number") String number);
}