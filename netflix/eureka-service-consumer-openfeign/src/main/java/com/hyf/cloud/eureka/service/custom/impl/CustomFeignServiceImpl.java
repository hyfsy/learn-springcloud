package com.hyf.cloud.eureka.service.custom.impl;

import com.hyf.cloud.eureka.service.custom.CustomFeignService;
import feign.Request;
import org.springframework.data.domain.Pageable;

import java.net.URI;
import java.util.Map;

/**
 * @author baB_hyf
 * @date 2021/05/24
 */
public class CustomFeignServiceImpl implements CustomFeignService {

    @Override
    public String provider() {
        System.out.println("provider");
        return null;
    }

    @Override
    public String provider3(Request.Options options, String var,
                           String num, String param, String header,
                           Pageable pageable, String part) {
        System.out.println("provider3");
        return null;
    }

    @Override
    public String provider4() {
        System.out.println("provider4");
        return null;
    }

    @Override
    public String provider5(URI uri, String body, Map<String, String> headers) {
        System.out.println("provider5");
        return null;
    }
}
