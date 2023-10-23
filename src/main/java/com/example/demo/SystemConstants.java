package com.example.demo;

/**
 * 系统常量
 */
public interface SystemConstants {

    // 余额单位
    Integer BALANCE_UNIT = 10000000;
    // @formatter:off
    /** 每个桶集合存储最大值 */
    int LIST_SIZE = 200;
    /** 展示限制桶数 */
    int USER_IMP_COUNT_BUCKET = 2000000 / LIST_SIZE;
    /** 用户限制开关 */
    int USER_SWITCH_BUCKET = 3000000 / LIST_SIZE;
    /** 用户黑名单限制开关 */
    int USER_BLACK_BUCKET = 30000000 / LIST_SIZE;
    /** 用户IP黑名单限制开关 */
    int USER_BLACK_IP_BUCKET = 30000000 / LIST_SIZE;
    /** 滴滴用户黑名单限制开关 */
    int USER_BLACK_DIDI_BUCKET = 300000000 / LIST_SIZE;
    /** 滴滴唤起用户定向 */
    int USER_ORIEN_DIDI_BUCKET = 3000000 / LIST_SIZE;
    /** 重复上报数据统计 */
    int REPEAT_REPORT_BUCKET = 30000000 / LIST_SIZE;
    /** 直客投放用户频次限制 */
    int ZHIKE_USER_FREQUENCY_BUCKET = 3000000 / LIST_SIZE;
    int ZUIYOU_USER_FREQUENCY_BUCKET = 3000000 / LIST_SIZE;
    /** DPM 用户人群大小 */
    int RTA_USER_BUCKET = 2000000000 / 300;
    /** DAU 请求用户大小 */
    int DAU_USER_BUCKET = 2000000000 / LIST_SIZE;
    /** DPM 人群包大小 */
    int USER_DPM_BUCKET = 1000000000 / LIST_SIZE;
    /*DSP 用户 3000000000/300*/
    int DSP_USER_BUCKET = 10000000;
    /** 广泽请求频控限制 */
    int GUANG_ZE_REQ_BUCKET = 200000 / LIST_SIZE;
    // @formatter:on



}
