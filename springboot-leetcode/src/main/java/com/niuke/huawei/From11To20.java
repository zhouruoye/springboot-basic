package com.niuke.huawei;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class From11To20 {

    public static void main(String[] args) {
//        test11();

//        test12();

//        test13();

        test15();
    }

    /**
     * 描述
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     * 数据范围： 0 <= n <= 2^30 -1
     * 输入描述：
     * 输入一个int整数
     * 输出描述：
     * 将这个整数以字符串的形式逆序输出
     * 示例1
     * 输入：1516000
     * 输出：0006151
     */
    public static void test11() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();

        System.out.println(stringBuilder.toString());
    }

    /**
     * 描述
     * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     * 输入描述：
     * 输入一行，为一个只包含小写字母的字符串。
     * 输出描述：
     * 输出该字符串反转后的字符串。
     * 示例1
     * 输入：abcd
     * 输出：dcba
     */
    public static void test12() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();

        System.out.println(stringBuilder.toString());
    }

    /**
     * 描述
     * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
     * 注意本题有多组输入
     * 输入描述：
     * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
     * 输出描述：
     * 得到逆序的句子
     * 示例1
     * 输入：I am a boy
     * 输出：boy a am I
     */
    public static void test13() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] s1 = s.split(" ");
        List<String> list = Arrays.asList(s1);
        Collections.reverse(list);

        String collect = list.stream().collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    /**
     * 描述
     * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
     * 数据范围： 1≤n≤1000  ，字符串长度满足 1≤len≤100
     * 输入描述：
     * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
     * 输出描述：
     * 数据输出n行，输出结果为按照字典序排列的字符串。
     * 示例1
     * 输入：
     * 9
     * cap
     * to
     * cat
     * card
     * two
     * too
     * up
     * boat
     * boot
     * 输出：
     * boat
     * boot
     * cap
     * card
     * cat
     * to
     * too
     * two
     * up
     */
    public static void test14() {
        
    }

    public boolean compareString(String name1,String name2) {
        int length1 = name1.length();
        int length2 = name2.length();
        int min = Math.min(length1, length2);
        for (int i = 0; i < min; i++) {

        }

        return false;
    }

    /**
     * 描述
     * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
     * 数据范围：保证在 32 位整型数字范围内
     * 输入描述：
     *  输入一个整数（int类型）
     * 输出描述：
     *  这个数转换成2进制后，输出1的个数
     * 示例1
     * 输入：5
     * 输出：2
     */
    public static void test15() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int count = 0;

        while (i > 0) {
            if((i & 1) == 1) {
                count ++;
            }
            i = i >> 1;
        }

        System.out.println(count);
    }

    public static void test16() {

    }

    /**
     * 描述
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     * 输入：
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     * 坐标之间以;分隔。
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     * 下面是一个简单的例子 如：
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 处理过程：
     * 起点（0,0）
     * +   A10   =  （-10,0）
     * +   S20   =  (-10,-20)
     * +   W10  =  (-10,-10)
     * +   D30  =  (20,-10)
     * +   x    =  无效
     * +   A1A   =  无效
     * +   B10A11   =  无效
     * +  一个空 不影响
     * +   A10  =  (10,-10)
     * 结果 （10， -10）
     * 数据范围：每组输入的字符串长度满足 1≤n≤10000  ，坐标保证满足 -2^31 <= x,y <= 2^31-1，且数字部分仅含正数
     * 输入描述：
     * 一行字符串
     * 输出描述：
     * 最终坐标，以逗号分隔
     */
    public static void test17() {
        String str = "A10";
    }
}
