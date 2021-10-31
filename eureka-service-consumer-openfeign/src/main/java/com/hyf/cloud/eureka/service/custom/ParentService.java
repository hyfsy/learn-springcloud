package com.hyf.cloud.nacos.service.custom;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baB_hyf
 * @date 2021/05/25
 */
@RequestMapping("second2") // 以父接口为主
public interface ParentService {

    @RequestMapping("provider4")
    String provider4();
}
