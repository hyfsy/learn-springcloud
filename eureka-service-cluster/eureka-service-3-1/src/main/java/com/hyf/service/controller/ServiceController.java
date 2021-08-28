package com.hyf.service.controller;

import com.hyf.service.config.ServiceProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2021/06/12
 */
@RestController
@RequestMapping("service")
public class ServiceController extends ServiceProvider {

    @RequestMapping("1")
    public String _1() {
        return "success3_1";
    }
}
