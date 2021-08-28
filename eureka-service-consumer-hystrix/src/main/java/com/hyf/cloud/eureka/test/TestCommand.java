package com.hyf.cloud.eureka.test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author baB_hyf
 * @date 2021/05/30
 */
public class TestCommand {

    public static void main(String[] args) throws Exception {
        MyCommand myCommand = new MyCommand(HystrixCommandGroupKey.Factory.asKey("11"));
        Integer run = myCommand.execute();
        System.out.println(run);
    }

    static class MyCommand extends HystrixCommand<Integer> {

        protected MyCommand(HystrixCommandGroupKey group) {
            super(group);
        }

        @Override
        protected Integer run() throws Exception {

            System.out.println("throw ex");
            throw new RuntimeException("1");
        }

        @Override
        protected Integer getFallback() {
            return 2;
        }
    }
}
