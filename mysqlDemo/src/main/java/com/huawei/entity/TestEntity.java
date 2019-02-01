
package com.huawei.entity;

public class TestEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "this name is : " + name;
    }

    public TestEntity(String name) {
        this.name = name;
    }
    public TestEntity() {
    }
}
