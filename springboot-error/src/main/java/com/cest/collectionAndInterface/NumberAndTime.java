package com.cest.collectionAndInterface;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * 数值计算和时间计算
 */
public class NumberAndTime {

    /**
     * scale 需要和小数位匹配
     */
    private static void scaleProblem() {
        BigDecimal bigDecimal = new BigDecimal("12.3241");
        BigDecimal bigDecimalNew1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimalNew1);
        // ArithmeticException 精度不匹配 出现异常
        BigDecimal bigDecimalNew2 = bigDecimal.setScale(2);
        System.out.println(bigDecimalNew2);
    }

    /**
     * 出现除不尽的情况 --> 需要定义精度
     */
    private static void divideProblem() {
        BigDecimal divide1 = new BigDecimal(1).divide(new BigDecimal(3), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide1);
        // ArithmeticException 除不尽
        BigDecimal divide2 = new BigDecimal(1).divide(new BigDecimal(3));
        System.out.println(divide2);
    }

    /**
     * 精度问题导致比较结果不一致
     */
    private static void equalsProblem() {
        BigDecimal bigDecimal1 = new BigDecimal("0");
        BigDecimal bigDecimal2 = new BigDecimal("0.00");

        System.out.println(bigDecimal1.equals(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal2) == 0);
    }

    /**
     * 可以解析大于/等于它定义的时间精度
     */
    private static void formatTime() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(simpleDateFormat.parse("2010-12-42"));
        System.out.println(simpleDateFormat.parse("2010-12-42 12:32:21"));
        System.out.println(simpleDateFormat.parse("2010-12"));
    }

    public static void main(String[] args) throws Exception{
//        scaleProblem();
//        divideProblem();
        equalsProblem();
        formatTime();
    }
}
