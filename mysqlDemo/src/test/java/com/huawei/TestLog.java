package com.huawei;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test() {
        logger.debug("���debug�������־.....");  
        logger.info("���info�������־.....");  
        logger.error("���error�������־....."); 
    }

}
