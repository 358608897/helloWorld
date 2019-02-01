
package com.huawei;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huawei.dao.TestMapper;
import com.huawei.entity.TestEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-dao.xml")
public class TestDao {
    @Value("${userdnsdomain}")
    private String username;

    @Autowired
    private TestMapper mapper;

    @Test
    public void testDao() {
        TestEntity enetity = mapper.findTestByName("1");
        System.out.println(enetity.toString());
        System.out.println("********************:" + username);
    }

    @Test
    public void testSys() {
        Map<String, String> map = System.getenv();
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey().toLowerCase(Locale.US) + ":" + entry.getValue());
        }
    }
}
