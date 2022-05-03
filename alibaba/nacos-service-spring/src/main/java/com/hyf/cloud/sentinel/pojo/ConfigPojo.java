package com.hyf.cloud.sentinel.pojo;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosIgnore;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2021/08/01
 */
@Component
@NacosConfigurationProperties(dataId = "example")
public class ConfigPojo {

    private String id;
    private String name;

    @NacosIgnore
    private int age;

    @NacosProperty("gender")
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
