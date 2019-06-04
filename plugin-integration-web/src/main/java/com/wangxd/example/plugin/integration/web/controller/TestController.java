package com.wangxd.example.plugin.integration.web.controller;

import com.wangxd.example.plugin.integration.common.base.redis.RedisUtil;
import com.wangxd.example.plugin.integration.persistent.dao.BillHeadDao;
import com.wangxd.example.plugin.integration.persistent.entity.BillHeadEntity;
import com.wangxd.example.plugin.integration.service.api.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private BillHeadDao billHeadDao;

    @Autowired
    private TestService testService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/dao.do", produces = "application/json; charset=utf-8")
    public Object testDao(String headKey) throws Exception {

        logger.info("===========test==============");
        BillHeadEntity entity = billHeadDao.selectByPrimaryKey(headKey);
        if(entity != null){
            System.out.println(entity.getHeadKey() + "---" + entity.getHeadName());
        }

        redisUtil.setRedisStr("123", "test redisUtil", 10);

        System.out.println(redisUtil.getRedisStrByKey("123"));

        return "成功";
    }

}


