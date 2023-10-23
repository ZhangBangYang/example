package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by cjf on 2021/04/06.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeductionInfo {
    private Long slotId;
    private long winPrice;
    private long auctionPrice;

    private Integer advertiserId;;
    private Integer planId;;
}
