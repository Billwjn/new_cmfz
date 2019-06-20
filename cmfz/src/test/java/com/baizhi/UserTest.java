package com.baizhi;

import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        Map<String, Object> stringObjectMap = userService.queryStatistics();
        for (String s : stringObjectMap.keySet()) {
            System.out.println(stringObjectMap.get(s));
        }
    }
    @Test
    public void test2(){
        Map<String, Object> stringObjectMap = userService.queryDistribution();
        System.out.println(stringObjectMap);
    }
}
