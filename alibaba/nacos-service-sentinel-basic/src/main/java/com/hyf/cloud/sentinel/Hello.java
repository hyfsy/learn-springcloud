package com.hyf.cloud.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baB_hyf
 * @date 2021/09/14
 */
public class Hello {

    public static final String RESOURCE_NAME = "HelloWorld";

    public static void main(String[] args) {
        defineRule();
        defineResource();
    }

    public static void defineResource() {
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry(RESOURCE_NAME);

                System.out.println("hello world");

            } catch (BlockException e) {
                e.printStackTrace();
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }

            // try {
            //     Thread.sleep(100);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }

    public static void defineRule() {
        List<FlowRule> flowRuleList = new ArrayList<>();

        FlowRule flowRule = new FlowRule();
        flowRule.setResource(RESOURCE_NAME);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(20); // 20 QPS
        flowRule.setLimitApp("default"); // 流控针对的调用来源,default表示不区分
        flowRuleList.add(flowRule);

        FlowRuleManager.loadRules(flowRuleList);
    }
}
