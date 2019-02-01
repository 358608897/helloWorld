
package com.huawei.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.dao.TestMapper;
import com.huawei.entity.TestEntity;

@Service
public class TestService {
    private final static Logger logger = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private TestMapper mapper;

    public void addTest(TestEntity user) {
        logger.info("come in add service");
        mapper.addTest(user);
       /* TestEntity entity = mapper.findTestByName(user.getName());
        logger.info(" entity: {}", entity);*/
        logger.info("exit add service");
    }
    
    public TestEntity find() {
        TestEntity entity = mapper.findTestByName("pkqtest");
        logger.info(" entity: {}", entity);
        return entity;
    }
}
