package com.cest.f1100to1200;

public class From1110To1120 {

    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));
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
