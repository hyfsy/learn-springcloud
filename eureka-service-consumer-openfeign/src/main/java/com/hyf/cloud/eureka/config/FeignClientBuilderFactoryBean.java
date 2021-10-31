package com.hyf.cloud.nacos.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2021/05/24
 */
@Component
public class FeignClientBuilderFactoryBean implements FactoryBean<FeignClientBuilder>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public FeignClientBuilder getObject() throws Exception {
        return new FeignClientBuilder(applicationContext);
    }

    @Override
    public Class<?> getObjectType() {
        return FeignClientBuilder.class;
    }
}
