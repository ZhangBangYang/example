package com.example.demo;

/**
 * Redis key
 * <p> key 命名规范：系统名：业务模块：业务含义
 * <p> 缩写简称，减少 redis 内存消耗
 * ==================================
 * <p> r：rtb
 * <p> u: user
 * <p> da: data
 * <p> sl: slot
 * <p> cr: creative
 * <p> sw: switch
 * ==================================
 *
 * @author by cjf on 2021/4/5.
 */
public interface RedisConstants {

    // 用户限制开关
    String USER_SWITCH = "r:u:sw:";
    // 测试用例响应数据
    String TEST_RES_DATA = "r:t:da:";
    // 用户请求参数过滤开关
    String USER_FILTER = "r:u:filter";
    // 用户黑名单
    String USER_BLACK = "r:u:b:";
    // 用户定向数据
    String USER_DMP = "r:u:dp:";
    // 用户白名单
    String USER_WHITE = "r:u:white";
    // HASH 用户IP黑名单
    String USER_BLACK_IP = "r:u:b:ip:";
    // 滴滴黑名单用户
    String USER_BLACK_DIDI = "r:u:b:d:";
    // 滴滴包名定向
    String USER_ORIEN_DIDI = "r:u:o:d:";
    // 用户展示次数
    String USER_IMP_COUNT = "r:u:ic:";
    // 重复上报数据统计
    String REPEAT_REPORT = "r:u:rpe:";
    // 广泽请求频控统计
    String GUANG_ZE_REQ_COUNT = "r:u:gz:req:";
    // 直客上报用户统计
    String ZHIKEY_REPORT = "r:u:zkrep:";
    // 数据统计
    String DATA_REPROT = "r:da:report";
    // 竟得数据统计
    String DATA_REPROT_WIN = "r:da:report:win:";
    // 展示数据统计
    String DATA_REPROT_SHOW = "r:da:report:show:";

    // 请求数统计
    String DATA_REPORT_REQ = "r:da:report:req:";


    // 点击数据统计
    String DATA_REPROT_CLK = "r:da:report:clk:";
    // 计费状态 hash key:date_slot
    String DATA_BILLING_STATE = "r:da:billing:state";
    // dsp计费状态 hash key:date_slot
    String DATA_BILLING_STATE_DSP = "r:da:billing:state:dsp";
    // RTA 用户标签，hash， key-> usermd5,val-> bitset
    String RTA_USER_TAG = "r:d:a:";
    // 秒针过滤总请求记录
    String SECOND_HAND_COUNT = "r:da:sh:count:";
    // 秒针过滤比例统计 key：channel_id + _ + slot_id + dsp_id + _ + dsp_slot_id
    String SECOND_HAND_RATIO = "r:da:sh";
    // 秒针非过滤比例统计 key：channel_id + _ + slot_id + dsp_id + _ + dsp_slot_id
    String SECOND_HAND_RATIO_NO = "r:da:shNo";
    // 秒针过滤调用接口实际数量 key：channel_id + _ + slot_id + dsp_id + _ + dsp_slot_id
    String SECOND_HAND_INTERFACE_CALL_NUMBER = "r:da:shicn";
    // 数据刷新
    String DATA_REFRESH = "r:da:refresh";
    // 数据更新
    String DATA_UPDATE = "r:da:update";
    // 请求日志 放在 ADX-ADMIN 后台项目定时器执行
    String DATA_REQUEST_INFO = "r:da:req:info";
    // 响应日志 放在 ADX-ADMIN 后台项目定时器执行
    String DATA_REQUEST_MATERIAL = "r:da:req:material";
    // 带 header 头的广告编号添加 Redis
    String SLOT_HEADER_DATE = "r:da:header";
    // 广告位流量限制, key = SLOT_FLOW_slotId_dspSlotId
    String SLOT_FLOW = "r:sl:flow";
    // DSP 广告位QPS限制
    String DSP_SLOT_FLOW_LIMIT = "r:sl:dsp:qps:";
    // 渠道广告位QPS限制
    String CHANNEL_SLOT_FLOW_LIMIT = "r:sl:ch:qps:";
    // 广告位流量限制总量, key = SLOT_FLOW_slotId_dspSlotId
    String SLOT_FLOW_TOTAL = "r:sl:flow:total";
    // 广告位流量开关, val = slotId_dspSlotId_0/1 0表示打开，1表示禁止
    String SLOT_SWITCH_TOPIC = "r:sl:switch";
    // DSP 广告位匀速流量限制, key = dspSlotId
    String SLOT_DSP_FLOW = "r:sl:dsp:flow";
    // DSP 广告位流量限制总量, key = dspSlotId
    String SLOT_DSP_TOTAL = "r:sl:dsp:total";
    // DSP 广告位流量开关, val = dspSlotId_0/1 0表示打开，1表示禁止
    String SLOT_DSP_SWITCH_TOPIC = "r:sl:dsp:switch";
    // set 直客用户频次限制
    String ZHIKE_USER_FREQUENCY = "r:da:zk:fr:";
    String ZUIYOU_USER_FREQUENCY = "r:da:zy:fr:";
    String ZUIYOU_USER_COUNT = "r:da:zy:fr:count:";
    // hash 域名映射 k->域名 v->code
    String DOMAIN_NAME_MAP = "r:cfg:domain:name:map";
    // hash 域名映射 k->code v->域名
    String DOMAIN_NAME_CODE_MAP = "r:cfg:domain:code:map";
    // HASH 添加创意去审核
    String CREATIVE_PUSH = "r:cr:push";
    // SET 提交创意状态
    String CREATIVE_PUSH_START = "r:cr:push:start";
    // SET 提交创意状态
    String CREATIVE_JIGUANG_START = "r:cr:push:start";
    // 滴滴广告位映射关系
    String DIDI_SLOT_MAP = "r:cfg:didi:slot:map";
    // 个推token配置
    String GETUI_TOKEN = "r:cfg:gt:token";
    // 滴滴个推人群包映射配置
    String DIDI_DMP_MAP = "r:cfg:gt:map";
    // 宏替换信息键值
    String MACRO_SUBSTITUTION = "r:ms:msInfo";
    // 关键字报表对应的利润率
    String KEYWORD_PROFIT_ATE = "r:da:profitate";
    // 点击行为方式
    String CLK_BEHAVIOR = "r:da:clk:behavior";


    // 应用对应的支出低价
    // hk  dspID_appBundle_oppoChannel_keyword   v price
    String OUT_LOW_PRICE = "OUT_LOW_PRICE";

    // 应用对应的收入低价
    // hk  dspID_appBundle_oppoChannel_keyword   v price
    String IN_LOW_PRICE = "IN_LOW_PRICE";

    // DSP 请求用户
    String DSP_USER = "r:s:u:";

    // DSP 用户新增时间
    String DSP_USER_ADD_TIME = "DSP_USER_LIMIT_ADD_TIME";

    // DSP 用户删除时间
    String DSP_USER_DEL_TIME = "DSP_USER_LIMIT_DEL_TIME";

    // DSP 请求用户 id
    String DAU_DSP_USER = "r:dau:u:";

    // 请求限制:统计总DAU数量
    String DAU_TOTAL = "r:dau:total:";

    // DAU 每小时均匀投放
    String DAU_HOUR_TOTAL = "r:dau:hour:total:";

    // 检查DAU:统计渠道广告位 DAU 数量,数据存储7天
    String DAU_SLOT_TOTAL = "r:{dauslot}:total:";

    // 检查DAU:统计dsp广告位 DAU 数量,数据存储7天
    String DAU_DSP_SLOT_TOTAL = "r:{daudspslot}:total:";

    // 检查DAU:统计dsp广告位+渠道广告位 DAU 数量,数据存储7天
    String DAU_SLOT_DSP_SLOT_TOTAL = "r:{dauslotdspslot}:total:";

    // DAU 上次统计记录
    String DAU_LAST_SMT_SLOT = "r:dau:lastsmt:slot:";
    String DAU_LAST_SMT_DSP_SLOT = "r:dau:lastsmt:dspslot:";
    String DAU_LAST_SMT_SLOT_DSP_SLOT = "r:dau:lastsmt:slotdspslot:";

    // 广告点击异常数据录入批次号
    String AD_WIDTH_HIGH_BATCH_NUM = "AD_WIDTH_HIGH_BATCH_NUM";
    String DSP_REPORT_DATA = "dr:report:data";

    // CPM扣费队列
    String DEDUCTION_RECORDING = "deduction_recording";

    // 广告主余额信息
    String ADVERTISER_BALANCE = "ADVERTISER_BALANCE_";

    // 广告主余额管制开关，进入此集合的广告主，CPM不可再投。
    String ADVERTISER_BALANCE_CONTROL = "ADVERTISER_BALANCE_CONTROL";

}
