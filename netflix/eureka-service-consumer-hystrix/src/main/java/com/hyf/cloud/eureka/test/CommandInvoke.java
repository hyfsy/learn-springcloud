package com.hyf.cloud.eureka.test;

import rx.Observable;

import java.util.concurrent.Future;

/**
 * @author baB_hyf
 * @date 2021/05/26
 */
public class CommandInvoke {

    public static void main(String[] args) {
        String s = new CommandHelloWorld("Bob").execute();
        Future<String> s2 = new CommandHelloWorld("Bob").queue();
        Observable<String> s3 = new CommandHelloWorld("Bob").observe();
    }
}
