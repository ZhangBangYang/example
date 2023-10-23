package com.example.demo;


public interface DeductionService {

    /**
     * 处理CPM扣费
     */
    void recordDeduction(LogDataEntity logData);

    void headerDeduction(DeductionInfo appPriceInfo);
}
