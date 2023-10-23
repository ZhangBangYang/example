package com.example.demo;

import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zby 2023/10/19 11:33
 */
@RestController
public class RedisTestController {

    @Resource
    private StringRedisTemplate redis;

    @Autowired
    Environment environment;

    @Resource
    private DeductionService deductionService;

    @GetMapping("/test")
    public String selectAll() throws IllegalAccessException, InstantiationException {

        // 保存扣费信息到Redis列表。
        LogDataEntity logDataEntity = new LogDataEntity();
        logDataEntity.setAdvertiserId(21);
        logDataEntity.setPlanId(1001);
        logDataEntity.setBasePrice(500000L);
        logDataEntity.setAuctionPrice(500000L);
        logDataEntity.setSlotId(2013L);
        logDataEntity.setChargeMode(4);

        deductionService.recordDeduction(logDataEntity);

        return "OK";
    }

    public static <E, T> T copyProperties(E srcObject, Class<T> destClazz) {
        try {
            if (null == srcObject) {
                return destClazz.newInstance();
            } else {
                String strObj = com.alibaba.fastjson.JSON.toJSONString(srcObject);
                return JSON.parseObject(strObj, destClazz);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("xxx", e);
        }
    }
}
