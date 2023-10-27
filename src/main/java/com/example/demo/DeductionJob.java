package com.example.demo;

import com.alibaba.fastjson2.JSON;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 2022-09-13 17:08:54 zby
 */
@Component
public class DeductionJob {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Logger elog = LoggerFactory.getLogger("error");


    @Resource
    private StringRedisTemplate redis;

    @Resource
    private DeductionServiceImpl deductionService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void deductionTiming() {
        // 加锁防止并发修改
        Boolean lock = redis.opsForValue().setIfAbsent("deduction{Timing}", "1");
        if (!lock) {
            return;
        }
        try {
            log.info("deductionTiming");
            while (true) {
                Long count = redis.opsForList().size(RedisConstants.DEDUCTION_RECORDING);
                if (count == null || count <= 0) {
                    break;
                }
                String content = redis.opsForList().rightPop(RedisConstants.DEDUCTION_RECORDING);
                DeductionInfo appPriceInfo = JSON.parseObject(content, DeductionInfo.class);
                deductionService.headerDeduction(appPriceInfo);
                // 你好
            }
        } catch (Exception e) {
            elog.error("扣款异常：error:{}", e.getMessage(), e);
        } finally {
            redis.delete("deduction{Timing}");
        }
    }

}

