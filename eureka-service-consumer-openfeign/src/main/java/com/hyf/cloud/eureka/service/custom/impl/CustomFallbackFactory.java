// package com.hyf.eureka.service.custom.impl;
//
// import com.hyf.eureka.service.custom.CustomFeignService;
// import feign.hystrix.FallbackFactory;
//
// /**
//  * @author baB_hyf
//  * @date 2021/05/24
//  */
// public class CustomFallbackFactory implements FallbackFactory<CustomFeignService> {
//
//     @Override
//     public CustomFeignService create(Throwable throwable) {
//         if (throwable != null) {
//             return new CustomFeignServiceImpl();
//         }
//         else {
//             throw new RuntimeException("Must not happen");
//         }
//     }
// }
