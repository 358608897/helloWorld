package com.huawei;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test() {
        logger.debug("输出debug级别的日志.....");  
        logger.info("输出info级别的日志.....");  
        logger.error("输出error级别的日志....."); 
    }

}
