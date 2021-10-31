package com.hyf.cloud.nacos.config;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author baB_hyf
 * @date 2021/05/14
 */
@Component
public class EnvironmentComponent {

    @Autowired
    private Environment environment;

    @PostConstruct
    private void getEnv() {
        System.out.println(1);
    }
}
