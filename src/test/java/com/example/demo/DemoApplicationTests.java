package com.example.demo;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    StringRedisTemplate redis;

    @Test
    void contextLoads() {

        // 获取成功就是 ture; 获取不成功就是  false
        Boolean lock = redis.opsForValue().setIfAbsent("lock", "1", 60, TimeUnit.SECONDS);
        System.out.println(lock);
    }

}
