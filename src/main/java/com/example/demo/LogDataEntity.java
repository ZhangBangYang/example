package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 竞价通知 数据宽表(LogWin)表实体类
 *
 * @author cjf
 * @since 2020-04-10 17:59:44
 */

@Data
@Builder
@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
public class LogDataEntity {
    //数据对应的竞价请求时间(分钟)
    private String timeKeyReq;
    //数据对应的上报请求时间(分钟)
    private String timeKeyRep;
    //数据对应的上报请求时间(天)
    private String dateReq;
    //数据对应的上报请求时间(年)
    private int year;
    //数据对应的上报请求时间(月)
    private int month;
    //数据对应的上报请求时间(天)
    private int day;
    //数据对应的上报请求时间(小时)
    private int hour;
    //媒体编号
    private int mediaId;

    private int templateId;
    //代理编号
    private int proxyId;
    //广告主编号
    private int advertiserId;
    //广告组编号
    private int adGroupId;
    //计划编号
    private int planId;
    //创意编号
    private int creativeId;
    //应用编号
    private int appId;
    //竞价请求id
    private String id;
    //参与竞价id
    private String bidId;
    //版位id
    private String impId;
    //adx广告位
    private Long slotId;
    //广告受众id(优先device_did)
    private String userId;
    //设备制造商，例如 "Apple"
    private String deviceMark;
    //设备型号，例如 "iphone"
    private String deviceModel;
    //硬件设备ID(例如 IMEI)
    private String deviceDid;
    //设备平台ID(例如 Android ID)
    private String deviceDpid;
    //MAC地址的SHA1哈希值
    private String deviceMac;
    //设备类型 1:iPhone;2:android;4:其他
    private int deviceDevicetype;
    //省级
    private String province;
    //城市
    private String city;
    //设备操作系统， 例如 “ios"
    private String os;
    //设备操作系统版本号， 例如 “3.1.2”
    private String osv;
    //IP地址
    private String ip;
    //网络连接类型 Unknown = 0, Ethernet  = 1  WIFI  = 2, Cellular Network – Unknown Generation = 3  2G = 4, 3G = 5  4G = 6, 5G = 7
    private int connectiontype;
    //运营商代码,MCC(Mobile Country Code)和 MNC （Mobile Network Code）的组合，参考 http://en.wikipedia.org/wiki/Mobile_Network_Code。 具体描述为：-1 未知, 46000：中国移动（China Mobile） 46001：中国联通（China Unicom） 46003：中国电信（China Telecom） 46020：中国铁通（China Tietong）
    private String carrier;
    //竞价出价,单位0.0000001rmb
    private long bidPrice;
    //最终拍卖价格,单位0.0000001rmb
    private long auctionPrice;
    //额外字段
    private String extra1;
    //额外字段
    private String extra2;
    //额外字段
    private String extra3;
    //额外字段
    private String extra4;
    //额外字段
    private String extra5;
    // 计费粒度   默认 1 表示天  2 表示小时
    private Integer billingGranularity;

    //广告主的基础出价, 单位0.0000001rmb
    private long basePrice;

    private int showSmt;
    private int uniShowSmt;
    private int clkSmt;
    private int uniClkSmt;

    // 计费模式 0-CPM ,1-CPD ,2-CPA,3-CPT
    private int chargeMode;

    // 请求数。  为了数据保留一定数据维度，这里实际是填充的数据。
    private int reqSmt;
}
