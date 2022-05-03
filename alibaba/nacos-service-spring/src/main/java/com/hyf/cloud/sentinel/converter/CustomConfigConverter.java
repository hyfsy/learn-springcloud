package com.hyf.cloud.sentinel.converter;

import com.alibaba.nacos.api.config.convert.NacosConfigConverter;

/**
 * 如果定义名为nacosConfigConversionService的Spring Bean，其类型为ConversionService，
 * 则将忽略DefaultFormattingConversionService
 *
 * @author baB_hyf
 * @date 2021/07/25
 */
public class CustomConfigConverter implements NacosConfigConverter<CustomConfigConverter.Person> {

    @Override
    public boolean canConvert(Class<Person> targetType) {
        return false;
    }

    @Override
    public Person convert(String config) {
        return null;
    }

    public static class Person {
        private String id;
        private String name;
    }
}
