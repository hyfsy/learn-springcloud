package com.hyf.cloud.eureka.controller;

import com.hyf.cloud.eureka.service.FeignProxyService;
import com.hyf.cloud.eureka.service.custom.CustomFeignService;
import feign.Request;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author baB_hyf
 * @date 2021/05/17
 */
@RestController
@RequestMapping("openfeign")
public class OpenFeignController {

    @Resource
    private FeignProxyService  feignProxyService;
    @Resource
    private CustomFeignService customFeignService;

    @RequestMapping
    public String _0() {
        return feignProxyService.provider();
    }

    @RequestMapping("1")
    public String _1() {
        System.out.println(customFeignService);
        String result = customFeignService.provider();
        // System.out.println(result);
        return result;
    }

    @RequestMapping("2")
    public String _2() {
        return customFeignService.provider2();
    }

    @RequestMapping("3")
    public String _3() {

        Request.Options options = new Request.Options();

        Sort sort = Sort.by(Sort.Order.desc("name"), Sort.Order.asc("age"));
        PageRequest pageable = PageRequest.of(0, 10, sort);
        // QPageRequest pageable = QPageRequest.of(0, 10); // querydsl

        String var = "MatrixVariable";
        String num = "PathVariable";
        String param = "RequestParam";
        String header = "RequestHeader";
        String part = "RequestPart";

        return customFeignService.provider3(options, var, num, param, header, pageable, part);
    }

    @RequestMapping("4")
    public String _4() {
        return customFeignService.provider4();
    }

    @RequestMapping("5")
    public String _5() {
        URI uri = URI.create("127.0.0.1");
        String body = "Hello";
        Map<String, String> headers = new HashMap<>();
        return customFeignService.provider5(uri, body, headers);
    }
}
