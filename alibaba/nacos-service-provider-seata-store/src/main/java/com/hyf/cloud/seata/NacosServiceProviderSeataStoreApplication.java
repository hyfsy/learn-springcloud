package com.hyf.cloud.seata;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * -javaagent:E:\study\env\component\cloud-resources\skywalking\apache-skywalking-apm-8.5.0\agent\skywalking-agent.jar -Dskywalking.agent.service_name=seata_client_store -Dskywalking.plugin.jdbc.trace_sql_parameters=true
 *
 * @author baB_hyf
 * @date 2021/08/23
 */
@SpringBootApplication
@EnableAutoDataSourceProxy
@EnableFeignClients
public class NacosServiceProviderSeataStoreApplication {

    // http://localhost:8328/store/reduce?storeId=1&number=1

    public static void main(String[] args) {
        SpringApplication.run(NacosServiceProviderSeataStoreApplication.class, args);
    }
}
