package com.cest.design.structural.proxy.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cestlavie on 2019/11/14.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Empe {

    private String empeId;

    private String name;

    private int age;
}
