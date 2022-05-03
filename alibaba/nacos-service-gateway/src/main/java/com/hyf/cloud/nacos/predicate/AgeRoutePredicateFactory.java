package com.hyf.cloud.nacos.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author baB_hyf
 * @date 2021/06/17
 */
@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {

    public static final String MAX_AGE_KEY = "max";
    public static final String MIN_AGE_KEY = "min";

    public AgeRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(MIN_AGE_KEY, MAX_AGE_KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (GatewayPredicate) serverWebExchange -> {
            // ServerHttpRequest request = serverWebExchange.getRequest();
            // List<String> ageList = request.getQueryParams().get("age");
            // if (ageList == null || ageList.isEmpty()) {
            //     return false;
            // }
            // String age = ageList.get(0);
            // int i = Integer.parseInt(age);
            // return i > config.getMin() && i < config.getMax();

            return true;
        };
    }

    public static class Config {

        @NotNull
        private Integer max;
        @NotNull
        private Integer min;

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }
    }
}
