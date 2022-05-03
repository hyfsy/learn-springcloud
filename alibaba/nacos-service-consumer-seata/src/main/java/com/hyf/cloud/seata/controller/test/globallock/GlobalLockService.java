package com.hyf.cloud.seata.controller.test.globallock;

import io.seata.spring.annotation.GlobalLock;
import org.springframework.stereotype.Service;

/**
 * 设计这个注解的原因是在没有这个注解之前，需要查询分布式事务读已提交的数据，但业务本身不需要分布式事务。
 * 若使用GlobalTransactional注解就会增加一些没用的额外的rpc开销比如begin 返回xid，提交事务等。
 * GlobalLock简化了rpc过程，使其做到更高的性能。
 *
 * @author baB_hyf
 * @date 2021/08/31
 */
@Service
@GlobalLock
public class GlobalLockService {

    @GlobalLock // 方法优先
    public boolean test() {
        System.out.println("GlobalLock business");
        return true;
    }
}
