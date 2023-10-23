package com.example.demo;


import com.alibaba.fastjson2.JSON;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zby 2023/10/19 16:01
 */
@Service
@Slf4j
public class DeductionServiceImpl implements DeductionService {

    @Resource
    private StringRedisTemplate redis;

    private final Logger deductionLog = LoggerFactory.getLogger("deduction");


    @Override
    public void recordDeduction(LogDataEntity logData) {
        if (logData.getChargeMode() != 4) {
            return;
        }
        // 保存扣费信息到Redis列表。
        DeductionInfo deductionInfo = new DeductionInfo();
        deductionInfo.setAdvertiserId(logData.getAdvertiserId());
        deductionInfo.setPlanId(logData.getPlanId());
        deductionInfo.setWinPrice(logData.getBasePrice());
        deductionInfo.setAuctionPrice(logData.getAuctionPrice());
        deductionInfo.setSlotId(logData.getSlotId());

        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        redis.opsForList().leftPush(RedisConstants.DEDUCTION_RECORDING+addr.getHostAddress(), JSON.toJSONString(deductionInfo));
    }

    @Override
    public void headerDeduction(DeductionInfo appPriceInfo) {

        // 要扣除的金额
        BigDecimal amountDeducted = BigDecimal.valueOf(appPriceInfo.getAuctionPrice());
        // 获取当前金额
        Map<Object, Object> advertiserBalance = redis.opsForHash().entries(RedisConstants.ADVERTISER_BALANCE + appPriceInfo.getAdvertiserId());
        AdvertiserBalanceEntity advBalance = copyProperties(advertiserBalance, AdvertiserBalanceEntity.class);

        if (advBalance != null) {
            deductionLog.info("广告主:{},余额:{},扣除:{},扣费JSON信息:{}", appPriceInfo.getAdvertiserId(),
                    advBalance.getTotalBalance().divide(new BigDecimal(SystemConstants.BALANCE_UNIT), 2, RoundingMode.HALF_EVEN).toString(),
                    amountDeducted.divide(new BigDecimal(SystemConstants.BALANCE_UNIT), 2, RoundingMode.HALF_EVEN).toString(),
                    JSON.toJSONString(appPriceInfo));
            Map<String, String> param = new HashMap<>();


            if (advBalance.getGiveBalance().compareTo(amountDeducted) >= 0) {
                // 优先扣除赠送
                param.put("giveBalance", advBalance.getGiveBalance().subtract(amountDeducted).toString());
            } else if (advBalance.getGiveBalance().compareTo(new BigDecimal("0")) > 0) {
                // 赠送不足情况下先扣除赠送再扣余额
                BigDecimal residual = amountDeducted.subtract(advBalance.getGiveBalance());
                param.put("giveBalance", new BigDecimal("0").toString());
                param.put("cashBalance", advBalance.getCashBalance().subtract(residual).toString());
            } else {
                // 扣余额
                param.put("cashBalance", advBalance.getCashBalance().subtract(amountDeducted).toString());
            }
            BigDecimal totalBalance = advBalance.getTotalBalance().subtract(amountDeducted);
            param.put("totalBalance", totalBalance.toString());

            // 金额管制,如果金额小于10元就不投放CPM。
            if (totalBalance.compareTo(new BigDecimal("100000000")) < 0 ) {
                BigDecimal balance = totalBalance.divide(new BigDecimal(SystemConstants.BALANCE_UNIT), 2, RoundingMode.HALF_EVEN);
                redis.opsForHash().put(RedisConstants.ADVERTISER_BALANCE_CONTROL,appPriceInfo.getAdvertiserId().toString(),balance.toString());
            } else {
                redis.opsForHash().delete(RedisConstants.ADVERTISER_BALANCE_CONTROL,appPriceInfo.getAdvertiserId().toString());
            }

            redis.opsForHash().putAll(RedisConstants.ADVERTISER_BALANCE + appPriceInfo.getAdvertiserId(), param);
        }


    }



    public static <E, T> T copyProperties(E srcObject, Class<T> destClazz) {
        try {
            if (null == srcObject) {
                return destClazz.newInstance();
            } else {
                String strObj = JSON.toJSONString(srcObject);
                return JSON.parseObject(strObj, destClazz);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            log.info("属性拷贝失败");
            throw new RuntimeException();
        }
    }

}
