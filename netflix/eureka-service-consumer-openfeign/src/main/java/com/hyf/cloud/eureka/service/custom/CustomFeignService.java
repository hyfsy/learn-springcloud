package com.hyf.cloud.eureka.service.custom;

import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

/**
 * @author baB_hyf
 * @date 2021/05/23
 */
@FeignClient(value = "eureka-service-provider2", path = "/first", url = "http://localhost:${server.port}/")
@RequestMapping("/second")
public interface CustomFeignService extends ParentService {

    @RequestMapping("provider")
    String provider();

    // 普通的调用
    @RequestMapping("provider2")
    default String provider2() {
        return "provider2";
    }

    // @CollectionFormat // 集合的分割格式
    @RequestMapping("/provider3/${uri-placeholder}/{num};{var}")
    String provider3(Request.Options options,
                     @MatrixVariable("var") String var, // 需要 -parameters 的支持才可以不指定
                     @PathVariable("num") String num, // 需要 -parameters 的支持才可以不指定
                     @RequestParam("param") String param, // 需要 -parameters 的支持才可以不指定
                     @RequestHeader("header") String header, // 需要 -parameters 的支持才可以不指定
                     @SpringQueryMap(true) Pageable pageable,
                     @RequestPart("part") String part // 需要 -parameters 的支持才可以不指定
    );

    @RequestMapping("provider5")
    String provider5(URI uri, String body /* only one */, @RequestHeader Map<String, String> headers);
}
