package com.hyf.cloud.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@RestController
public class ProviderController {

    @RequestMapping("provider")
    public String provider() {
        return "provider03";
    }
}
