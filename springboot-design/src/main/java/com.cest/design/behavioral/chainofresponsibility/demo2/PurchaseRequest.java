package com.cest.design.behavioral.chainofresponsibility.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 采购请求类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest {

    //金额
    private double amount;

    //采购数量
    private int number;

    //采购目的
    private String purpose;
}
