package com.cest.f1101to1200;

public class From1111To1120 {

    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));
    }




    /**
     * 1118. 一月有多少天
     * 指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
     * 示例 1：
     * 输入：Y = 1992, M = 7
     * 输出：31
     * 示例 2：
     * 输入：Y = 2000, M = 2
     * 输出：29
     * 示例 3：
     * 输入：Y = 1900, M = 2
     * 输出：28
     * 普通闰年：公历年份是 4 的倍数，且不是 100 的倍数的，为闰年（如 2004 年就是闰年）。
     * 世纪闰年：公历年份是整百数的，必须是 400 的倍数才是世纪闰年（如 1900 年不是世纪闰年，2000 年是世纪闰年）。
     * @param Y
     * @param M
     * @return
     */
    public int numberOfDays(int Y, int M) {
//        LocalDate.of(Y, M, 1).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(((Y%4 == 0 && Y%100 != 0) || Y%400 == 0) && M==2) {
            return 29;
        }
        return days[M-1];
    }

    /**
     * 1119. 删去字符串中的元音
     * 输入："leetcodeisacommunityforcoders"
     * 输出："ltcdscmmntyfrcdrs"
     * 输入："aeiou"
     * 输出：""
     * @param s
     * @return
     */
    public static String removeVowels(String s) {
        return s.replaceAll("[aeiou]", "");
    }
}
