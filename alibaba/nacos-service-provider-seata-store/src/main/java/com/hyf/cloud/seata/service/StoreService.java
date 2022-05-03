package com.hyf.cloud.seata.service;

import com.hyf.cloud.seata.mapper.StoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/08/24
 */
@Service
public class StoreService {

    @Resource
    private StoreMapper storeMapper;

    public boolean reduce(String storeId, Integer number) {
        // throwEx();
        return storeMapper.reduce(storeId, number);
    }

    public void throwEx() {
        throw new RuntimeException("store");
    }
}
