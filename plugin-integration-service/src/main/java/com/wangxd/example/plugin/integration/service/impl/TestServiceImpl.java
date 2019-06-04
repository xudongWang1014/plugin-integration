package com.wangxd.example.plugin.integration.service.impl;

import com.wangxd.example.plugin.integration.persistent.dao.BillHeadDao;
import com.wangxd.example.plugin.integration.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private BillHeadDao billHeadDao;
}
