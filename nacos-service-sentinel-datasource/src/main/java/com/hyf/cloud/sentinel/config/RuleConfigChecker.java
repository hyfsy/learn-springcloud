package com.hyf.cloud.sentinel.config;

import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2021/10/17
 */
@Component
public class RuleConfigChecker implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        // [{
        // 	"clusterMode":false,
        // 	"controlBehavior":0,
        // 	"count":20.0,
        // 	"grade":1,
        // 	"limitApp":"default",
        // 	"maxQueueingTimeMs":500,
        // 	"resource":"resourceName",
        // 	"strategy":0,
        // 	"warmUpPeriodSec":10
        // }]

        // List<HashMap<Object, Object>>
        System.out.println("INFO: rule info -> " + FlowRuleManager.getRules());
    }
}
