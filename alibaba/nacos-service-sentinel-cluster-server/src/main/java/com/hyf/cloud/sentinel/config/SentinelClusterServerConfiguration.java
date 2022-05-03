package com.hyf.cloud.sentinel.config;

import com.alibaba.csp.sentinel.cluster.ClusterConstants;
import com.alibaba.csp.sentinel.cluster.ClusterStateManager;
import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterFlowRuleManager;
import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterParamFlowRuleManager;
import com.alibaba.csp.sentinel.cluster.server.ServerConstants;
import com.alibaba.csp.sentinel.cluster.server.config.ClusterServerConfigManager;
import com.alibaba.csp.sentinel.cluster.server.config.ServerFlowConfig;
import com.alibaba.csp.sentinel.cluster.server.config.ServerTransportConfig;
import com.alibaba.csp.sentinel.slots.block.ClusterRuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowClusterConfig;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author baB_hyf
 * @date 2021/09/16
 */
@Configuration
public class SentinelClusterServerConfiguration {

    public static final String CLIENT_NAMESPACE    = "nacos-service-sentinel-cluster-client"; // 规则作用的服务名
    public static final String FLOW_RESOURCE_NAME  = "/flow";
    public static final String PARAM_RESOURCE_NAME = "/param";

    @PostConstruct
    public void post() {
        // 先配置再切换模式

        // 客户端管理器的配置
        applyConfig();

        // 切换模式
        ClusterStateManager.applyState(ClusterStateManager.CLUSTER_SERVER);

        // 流控规则注册
        registerRule();
    }

    private void registerRule() {

        // 流控规则
        FlowRule flowRule = new FlowRule(FLOW_RESOURCE_NAME);
        // flowRule.setGrade(RuleConstant.FLOW_GRADE_THREAD);
        flowRule.setCount(1); // 1 QPS
        flowRule.setClusterMode(true);
        ClusterFlowConfig clusterFlowConfig = new ClusterFlowConfig();
        clusterFlowConfig.setFlowId(1L);
        clusterFlowConfig.setThresholdType(ClusterRuleConstant.FLOW_THRESHOLD_GLOBAL); // 单机均摊 | 全局阈值
        // 供服务端的指标使用
        clusterFlowConfig.setSampleCount(10);
        clusterFlowConfig.setWindowIntervalMs(1000);
        flowRule.setClusterConfig(clusterFlowConfig);
        // String namespace = ConfigSupplierRegistry.getNamespaceSupplier().get(); // server namespace
        ClusterFlowRuleManager.loadRules(CLIENT_NAMESPACE, Collections.singletonList(flowRule));

        // 热点参数流控规则
        ParamFlowRule paramFlowRule = new ParamFlowRule(PARAM_RESOURCE_NAME);
        paramFlowRule.setCount(2); // 在参数没有指定ParamFlowItem的时候或参数值不匹配的情况下，会当做流控规则的默认数量
        paramFlowRule.setParamIdx(0); // 没啥用，但必须指定（索引功能由客户端处理了）
        // 指定客户端流控参数对应的值，值的token数量，值类型（初始化解析用）
        paramFlowRule.setParamFlowItemList(Collections.singletonList(new ParamFlowItem("1", 1, "java.lang.String")));
        paramFlowRule.setClusterMode(true);
        paramFlowRule.setClusterConfig(new ParamFlowClusterConfig().setFlowId(2L));
        ClusterParamFlowRuleManager.loadRules(CLIENT_NAMESPACE, Collections.singletonList(paramFlowRule));

        // 动态规则
        // ClusterFlowRuleManager.setPropertySupplier(namespace -> new DynamicSentinelProperty<>());
    }

    private void applyConfig() {
        // 手动配置源
        ClusterServerConfigManager.loadGlobalFlowConfig(new ServerFlowConfig()
                .setSampleCount(ServerFlowConfig.DEFAULT_SAMPLE_COUNT));
        ClusterServerConfigManager.loadServerNamespaceSet(
                new HashSet<>(Arrays.asList(ServerConstants.DEFAULT_NAMESPACE, CLIENT_NAMESPACE)));
        ClusterServerConfigManager.loadGlobalTransportConfig(new ServerTransportConfig()
                .setPort(ClusterConstants.DEFAULT_CLUSTER_SERVER_PORT)
                .setIdleSeconds(ServerTransportConfig.DEFAULT_IDLE_SECONDS));
        // not support namespace yet
        // ClusterServerConfigManager.loadFlowConfig("default", new ServerFlowConfig().setSampleCount(2));

        // 动态配置源
        // ClusterServerConfigManager.registerNamespaceSetProperty(new DynamicSentinelProperty<>());
        // ClusterServerConfigManager.registerServerTransportProperty(new DynamicSentinelProperty<>());
        // ClusterServerConfigManager.registerGlobalServerFlowProperty(new DynamicSentinelProperty<>());
    }
}
