package com.wangxd.example.plugin.integration.dubbo.provider.impl;

import com.wangxd.example.plugin.integration.dubbo.api.service.TestDubboService;
import org.springframework.stereotype.Service;

/**
 * dubbo提供者测试
 */
@Service
public class TestDubboServiceImpl implements TestDubboService {
    @Override
    public void sayHello() {
        System.out.println("这是一个dubbo提供者实现类");
    }
}
