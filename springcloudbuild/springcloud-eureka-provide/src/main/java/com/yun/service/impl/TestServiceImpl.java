package com.yun.service.impl;

import com.yun.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String get(String name) {
        return name;
    }
}
