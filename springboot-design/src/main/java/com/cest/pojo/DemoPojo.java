package com.cest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoPojo {

    private String poolid;
    //订单号
    private String orderId;
    //订单名称
    private String name;

}
