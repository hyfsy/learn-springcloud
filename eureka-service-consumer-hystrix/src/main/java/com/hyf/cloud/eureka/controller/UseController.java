package com.hyf.cloud.nacos.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author baB_hyf
 * @date 2021/05/29
 */
@RestController
public class UseController {

    @RequestMapping("t1")

    @CacheResult(cacheKeyMethod = "cacheKey")
    @HystrixCommand(fallbackMethod = "fallback")
    // @CacheResult
    // public Future<String> aVoid(@CacheKey("id") User user)
    // or null
    public Future<String> t1(@CacheKey String s) {
        throw new RuntimeException("throw ex");
    }

    public String fallback(String s, Throwable t) {
        System.out.println("fallback");
        return "fallback";
    }

    public String cacheKey(String s) {
        return "cacheKey";
    }


    @RequestMapping("t2")
    @CacheRemove(commandKey = "t1")
    // @CacheRemove(commandKey = "t1", cacheKeyMethod = "cacheKey")
    @HystrixCommand
    public void clearCache() {
        System.out.println("clear cache success");
    }


    @RequestMapping("t3")
    @HystrixCollapser(batchMethod = "batchExecute")
    public void collapseBatchList(String s) {
        System.out.println("invoke collapse batch");
    }

    @HystrixCommand
    public List<String> batchExecute(List<String> sList) {
        return new ArrayList<>();
    }

    /*
        execution.isolation.strategy
        execution.isolation.thread.timeoutInMilliseconds
        execution.timeout.enabled
        execution.isolation.thread.interruptOnTimeout
        execution.isolation.semaphore.maxConcurrentRequests

        fallback.isolation.semaphore.maxConcurrentRequests
        fallback.enabled

        circuitBreaker.enabled
        circuitBreaker.requestVolumeThreshold
        circuitBreaker.sleepWindowInMilliseconds
        circuitBreaker.errorThresholdPercentage
        circuitBreaker.forceOpen
        circuitBreaker.forceClosed

        metrics.rollingPercentile.enabled
        metrics.rollingPercentile.timeInMilliseconds
        metrics.rollingPercentile.numBuckets
        metrics.rollingPercentile.bucketSize
        metrics.healthSnapshot.intervalInMilliseconds

        requestCache.enabled
        requestLog.enabled

        maxQueueSize
        coreSize
        keepAliveTimeMinutes
        queueSizeRejectionThreshold
        metrics.rollingStats.numBuckets
        metrics.rollingStats.timeInMilliseconds

        maxRequestsInBatch
        timerDelayInMilliseconds
     */

    // @see HystrixPropertiesManager
    @RequestMapping("t4")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
            @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true"),
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "10"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "10"),
            @HystrixProperty(name = "fallback.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.forceOpen", value = "false"),
            @HystrixProperty(name = "circuitBreaker.forceClosed", value = "false"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "10"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),
            @HystrixProperty(name = "metrics.rollingPercentile.enabled", value = "true"),
            @HystrixProperty(name = "metrics.rollingPercentile.timeInMilliseconds", value = "60000"),
            @HystrixProperty(name = "metrics.rollingPercentile.numBuckets", value = "6"),
            @HystrixProperty(name = "metrics.rollingPercentile.bucketSize", value = "100"),
            @HystrixProperty(name = "metrics.healthSnapshot.intervalInMilliseconds", value = "500"),
            @HystrixProperty(name = "requestCache.enabled", value = "true"),
            @HystrixProperty(name = "requestLog.enabled", value = "true")
    }, threadPoolProperties = {
            @HystrixProperty(name = "maxQueueSize", value = "-1"), // -1 SynchronousQueue else LinkedBlockingQueue
            @HystrixProperty(name = "coreSize", value = "10"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "5"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "10"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")

    })
    public String propertyUse() {
        return "invoke property";
    }

    // 不能两个注解放一个方法上
    @HystrixCollapser(batchMethod = "propertyUse", collapserProperties = {
            @HystrixProperty(name = "maxRequestsInBatch", value = "2147483647"), // Integer.MAX_VALUE
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "10"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "10"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),
            @HystrixProperty(name = "metrics.rollingPercentile.enabled", value = "true"),
            @HystrixProperty(name = "metrics.rollingPercentile.timeInMilliseconds", value = "60000"),
            @HystrixProperty(name = "metrics.rollingPercentile.numBuckets", value = "6"),
            @HystrixProperty(name = "metrics.rollingPercentile.bucketSize", value = "100"),
            @HystrixProperty(name = "requestCache.enabled", value = "true")
    })
    public String propertyUse2() {
        return "invoke property";
    }
}
