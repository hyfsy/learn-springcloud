package com.hyf.cloud.eureka.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author baB_hyf
 * @date 2021/05/23
 */
@Component
public class TemplateCollector {

    @LoadBalanced
    @Autowired(required = false)
    private List<TemplateConfiguration.Template> templateList;

    @PostConstruct
    public void post() {
        System.out.println(templateList);
    }
}
