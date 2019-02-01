package com.huawei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huawei.entity.TestEntity;
import com.huawei.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-dao.xml")
public class TestServiceDemo {
    
    @Autowired
    private TestService service;
    @Test
    public void test() {
        TestEntity user = new TestEntity("pkqtest1");
        service.find();
    }

}
