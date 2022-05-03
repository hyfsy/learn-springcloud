package com.hyf.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author baB_hyf
 * @date 2021/06/12
 */
public class ServiceProvider {

    @Value("#{'${services}'.split(',')}")
    private List<String> serviceList;

    @Resource
    private RestTemplate restTemplate;

    public String get(int index, String uri) {
        return get(index, uri, String.class);
    }

    public <T> T get(int index, String uri, Class<T> clazz) {
        return restTemplate.getForObject(getService(index, uri), clazz);
    }

    public String post(int index, String uri, Object body) {
        return post(index, uri, body, String.class);
    }

    public <T> T post(int index, String uri, Object body, Class<T> clazz) {
        return restTemplate.postForObject(getService(index, uri), body, clazz);
    }

    public String getService(int index, String uri) {
        return "http://" + serviceList.get(index).trim() + "/service/" + uri;
    }
}
