package com.niuke.huawei;

import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class From1To10 {

    public static void main(String[] args) {
//        test01();

//        test02();

//        test03();

//        test04();

//        test05();

        test06();

//        test07();

//        test08();

//        test09();

//        test10();
    }

    /**
     * 描述
     * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
     * 输入描述：
     * 输入一行，代表要计算的字符串，非空，长度小于5000。
     * 输出描述：
     * 输出一个整数，表示输入字符串最后一个单词的长度。
     */
    public static void test01() {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        if(StringUtils.isEmpty(next)) {
            System.out.println(0);
        }
        String[] s = next.split(" ");
        System.out.println(s[s.length - 1].length());
    }

    /**
     * 描述
     * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
     * 数据范围： 1 \le n \le 1000 \1≤n≤1000
     * 输入描述：
     * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
     * 输出描述：
     * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
     */
    public static void test02() {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        String target = sc.nextLine();

        next = next.toLowerCase();
        int length1 = next.length();

        target = target.toLowerCase();

        System.out.println(length1 - next.replaceAll(target,"").length());
    }

    /**
     * 描述
     * 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
     * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，输入的数字大小满足 1 \le val \le 500 \1≤val≤500
     * 输入描述：
     * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
     * 输出描述：
     * 输出多行，表示输入数据处理后的结果
     */
    public static void test03() {
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < next; i++) {
            int number = sc.nextInt();
            set.add(number);
        }
        List<Integer> integers = new ArrayList<>(set);
        integers = integers.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    /**
     * 描述
     * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * 输入描述：
     * 连续输入字符串(每个字符串长度小于等于100)
     * 输出描述：
     * 依次输出所有分割后的长度为8的新字符串
     * 示例1
     * 输入：abc
     * 输出：abc00000
     */
    public static void test04() {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        
        //需要补0的长度
        String bu = "";
        int i = 8 - next.length() % 8;
        if(i < 8) {
            for (int i1 = 0; i1 < i; i1++) {
                bu += 0;
            }
        }

        next = next + bu;

        int splitTimes = next.length() / 8;

        for (int i1 = 0; i1 < splitTimes; i1++) {
            System.out.println(next.substring(i1 * 8, (i1 + 1) * 8));
        }

    }

    /**
     * 描述
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
     * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
     * 31
     *  −1
     * 输入描述：
     * 输入一个十六进制的数值字符串。
     * 输出描述：
     * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
     * 示例1
     * 输入：0xAA
     * 输出：170
     */
    public static void test05() {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        System.out.println(Integer.parseInt(next.substring(2,next.length()),16));
    }

    /**
     * 描述
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     * 数据范围： 1 <= n <= 2 * 10^9 + 14
     * 输入描述：
     * 输入一个整数
     * 输出描述：
     * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
     * 示例1
     * 输入：180
     * 输出：2 2 3 3 5
     */
    public static void test06() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        int num = 2;
        List<String> list = new ArrayList<>();
        while(i > 1 || i > num) {
            if(i % num == 0) {
                list.add(num + "");
                i = i / num;
                continue;
            }
            int zhiShuBetweenNumber = getZhiShuBetweenNumber(num, i);

            if(zhiShuBetweenNumber == -1) {
                break;
            } else {
                num = zhiShuBetweenNumber;
            }
        }
        System.out.println(list.stream().collect(Collectors.joining(" ")));
    }

    public static boolean isZhiShu(int number) {
        for (int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getZhiShuBetweenNumber(int num1,int num2) {
        if(num1 > num2) {
            return -1;
        }

        if(isZhiShu(num2)) {
            return num2;
        }

        while(num1 < num2) {
            num1 ++;
            if(isZhiShu(num1)) {
                return num1;
            }
        }

        return -1;
    }

    /**
     * 描述
     * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
     * 数据范围：保证输入的数字在 32 位浮点数范围内
     * 输入描述：
     * 输入一个正浮点数值
     * 输出描述：
     * 输出该数值的近似整数值
     * 示例1
     * 输入：5.5
     * 输出：6
     * 说明：0.5>=0.5，所以5.5需要向上取整为6
     */
    public static void test07() {
        Scanner sc = new Scanner(System.in);
        double v = sc.nextDouble();
        BigDecimal bigDecimal = new BigDecimal(v);
        int i = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        System.out.println(i);
    }

    /**
     * 描述
     * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
     * 提示:
     * 0 <= index <= 11111111
     * 1 <= value <= 100000
     * 输入描述：
     * 先输入键值对的个数n（1 <= n <= 500）
     * 接下来n行每行输入成对的index和value值，以空格隔开
     * 输出描述：
     * 输出合并后的键值对（多行）
     * 示例1
     * 输入：
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     * 输出：
     * 0 3
     * 1 2
     * 3 4
     */
    public static void test08() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i1 = 0; i1 < i; i1++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            if(map.containsKey(key)) {
                Integer integer = map.get(key);
                map.put(key,value + integer);
            } else {
                map.put(key,value);
            }
        }

        map.forEach((k,v)-> {
            System.out.println(k + " " + v);
        });
    }

    /**
     * 描述
     * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 保证输入的整数最后一位不是 0 。
     * 数据范围： 1 <= n <= 10^8
     * 输入描述：
     * 输入一个int型整数
     * 输出描述：
     * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
     * 示例1
     * 输入：9876673
     * 输出：37689
     */
    public static void test09() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        String s1 = stringBuilder.toString();
        int length = s1.length();

        List<String> list = new ArrayList<>();

        String str = "";
        for (int i = 0; i < length; i++) {
            String substring = s1.substring(i, i + 1);
            if(list.contains(substring)) {
                continue;
            } else {
                str += substring;
                list.add(substring);
            }
        }
        System.out.println(str);
    }

    /**
     * 描述
     * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
     * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
     * 数据范围： 1 <= n <= 500
     * 输入描述：
     * 输入一行没有空格的字符串。
     * 输出描述：
     * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
     * 示例1
     * 输入：abc
     * 输出：3
     */
    public static void test10() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        System.out.println(set.size());
    }
}
