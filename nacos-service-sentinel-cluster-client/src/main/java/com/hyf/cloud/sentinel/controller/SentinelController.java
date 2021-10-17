package com.hyf.cloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author baB_hyf
 * @date 2021/10/17
 */
@RestController
public class SentinelController {

    // 普通限流，走MVC拦截器，资源名就是uri
    // resourceName -> /flow
    @SentinelResource
    @RequestMapping("flow")
    public void flow() {
        System.out.println("flow");
    }

    // 参数限流走aop，资源名变为
    // resourceName -> com.hyf.cloud.sentinel.controller.SentinelController:param(java.lang.String,java.lang.String)
    @SentinelResource(value = "/param", blockHandler = "paramBlock") // 此处强制指定
    @RequestMapping("param")
    public void param(@RequestParam(required = false) String p1,
                      @RequestParam(required = false) String p2,
                      HttpServletResponse response) {
        System.out.println("param");
    }

    public void paramBlock(String p1, String p2, HttpServletResponse response, BlockException e) {
        response.setStatus(429);

        try (PrintWriter out = response.getWriter()) {
            out.print("Blocked by Sentinel (flow limiting)");
            out.flush();
        } catch (IOException ioe) {
            throw new RuntimeException("response getWriter failed", ioe);
        }
    }
}
