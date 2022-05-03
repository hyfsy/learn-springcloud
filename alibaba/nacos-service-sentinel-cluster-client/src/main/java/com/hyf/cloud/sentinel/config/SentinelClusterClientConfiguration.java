package com.hyf.cloud.sentinel.config;

import com.alibaba.csp.sentinel.cluster.ClusterConstants;
import com.alibaba.csp.sentinel.cluster.ClusterStateManager;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientAssignConfig;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientConfig;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientConfigManager;
import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterFlowRuleManager;
import com.alibaba.csp.sentinel.property.DynamicSentinelProperty;
import com.alibaba.csp.sentinel.slots.block.ClusterRuleConstant;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowClusterConfig;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * @author baB_hyf
 * @date 2021/09/16
 */
@Configuration
public class SentinelClusterClientConfiguration {

    public static final String SERVER_ADDR         = "localhost";
    public static final String FLOW_RESOURCE_NAME  = "/flow";
    public static final String PARAM_RESOURCE_NAME = "/param";

    @PostConstruct
    public void post() {
        // 先配置再切换模式

        // 客户端管理器的配置
        applyConfig();

        // 切换模式
        ClusterStateManager.applyState(ClusterStateManager.CLUSTER_CLIENT);

        // 流控规则注册
        registerRule();
    }

    // 客户端的规则相当于设置一个映射，映射到服务端的规则
    private void registerRule() {

        // 流控规则
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(FLOW_RESOURCE_NAME);
        flowRule.setClusterMode(true);
        ClusterFlowConfig clusterFlowConfig = new ClusterFlowConfig();
        clusterFlowConfig.setFlowId(1L); // 规则编号，需要与服务端配置的规则匹配
        clusterFlowConfig.setStrategy(ClusterRuleConstant.FLOW_CLUSTER_STRATEGY_NORMAL); // 暂时只支持这个，没啥实际作用
        clusterFlowConfig.setFallbackToLocalWhenFail(false); // 服务端请求失败走本地限流
        flowRule.setClusterConfig(clusterFlowConfig);
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));

        // 热点参数流控规则
        ParamFlowRule paramFlowRule = new ParamFlowRule();
        paramFlowRule.setResource(PARAM_RESOURCE_NAME);
        paramFlowRule.setParamIdx(0); // 指定传给服务器的参数索引，参数可为单个参数或列表
        paramFlowRule.setClusterMode(true);
        paramFlowRule.setClusterConfig(new ParamFlowClusterConfig().setFlowId(2L));
        ParamFlowRuleManager.loadRules(Collections.singletonList(paramFlowRule));

        // 动态规则
        // ClusterFlowRuleManager.setPropertySupplier((namespace) -> new DynamicSentinelProperty<>());
    }

    private void applyConfig() {

        // 手动配置源
        ClusterClientConfigManager.applyNewConfig(new ClusterClientConfig()
                .setRequestTimeout(2000));
        ClusterClientConfigManager.applyNewAssignConfig(new ClusterClientAssignConfig()
                .setServerHost(SERVER_ADDR)
                .setServerPort(ClusterConstants.DEFAULT_CLUSTER_SERVER_PORT));

        // 动态配置源
        // ClusterClientConfigManager.registerClientConfigProperty(new DynamicSentinelProperty<>());
        // ClusterClientConfigManager.registerServerAssignProperty(new DynamicSentinelProperty<>());
    }
}
