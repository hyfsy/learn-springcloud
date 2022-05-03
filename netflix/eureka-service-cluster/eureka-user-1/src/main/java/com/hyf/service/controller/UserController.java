package com.hyf.service.controller;

import com.hyf.service.config.ServiceProvider;
import com.hyf.service.service.FeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/06/12
 */
@RestController
@RequestMapping("user")
public class UserController extends ServiceProvider {

    @Resource
    private FeignService feignService;

    @RequestMapping("1")
    public String _1() {
        return get(1, "1");
    }

    @RequestMapping("2")
    public String _2() {
        return feignService._2();
    }

    @RequestMapping("/{index}/{uri}")
    public String route(@PathVariable int index, @PathVariable String uri) {
        return get(index, uri);
    }
}
