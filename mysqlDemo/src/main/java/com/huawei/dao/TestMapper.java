
package com.huawei.dao;

import com.huawei.entity.TestEntity;

public interface TestMapper {

    void addTest(TestEntity user);

    TestEntity findTestByName(String name);
}
