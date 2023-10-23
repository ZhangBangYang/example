package com.example.demo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 广告组余额实体
 *
 * @author by cjf on 2019/04/03.
 */
@Data
public class AdvertiserBalanceEntity {

    // 赠送余额
    private BigDecimal giveBalance;
    // 现金余额
    private BigDecimal cashBalance;
    // 赠送余额 + 现金余额
    private BigDecimal totalBalance;

    public BigDecimal getGiveBalance() {
        return giveBalance != null ? giveBalance : new BigDecimal("0");
    }

    public BigDecimal getCashBalance() {
        return cashBalance != null ? cashBalance : new BigDecimal("0");
    }

    public BigDecimal getTotalBalance() {
        return totalBalance != null ? totalBalance : new BigDecimal("0");
    }
}
