package com.niuke.huawei;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class From21To30 {

    public static void main(String[] args) {
//        test21();
//        test22();
//        test23();
//        test26();
//        test27();
//        test29();
        test30();
    }


    public static void test21() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "2");
        map.put("b", "2");
        map.put("c", "2");
        map.put("d", "3");
        map.put("e", "3");
        map.put("f", "3");
        map.put("g", "4");
        map.put("h", "4");
        map.put("i", "4");
        map.put("j", "5");
        map.put("k", "5");
        map.put("l", "5");
        map.put("m", "6");
        map.put("n", "6");
        map.put("o", "6");
        map.put("p", "7");
        map.put("q", "7");
        map.put("r", "7");
        map.put("s", "7");
        map.put("t", "8");
        map.put("u", "8");
        map.put("v", "8");
        map.put("w", "9");
        map.put("x", "9");
        map.put("y", "9");
        map.put("z", "9");

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String newStr = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'z') {
                newStr += map.get(s.substring(i, i + 1));
            } else if ('A' <= c && c <= 'Y') {
                newStr += Character.toString((char) (c + 32 + 1));
            } else if ('Z' == c) {
                newStr += "a";
            } else {
                newStr += s.substring(i, i + 1);
            }
        }
        System.out.println(newStr);
    }

    public static void test22() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int i = sc.nextInt();

            if (i == 0) {
                break;
            }
            int count = 0;
            while (i >= 3) {
                count += i / 3;
                i = i % 3 + i / 3;
            }
            count = i == 2 ? count + 1 : count;
            System.out.println(count);
        }
    }

    public static void test23() {
        int[] letters = new int[]{0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 97] = letters[c - 97] + 1;
        }

        int min = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == 0) {
                continue;
            }

            if (min == 0) {
                min = letters[i];
            } else if (min > letters[i]) {
                min = letters[i];
            }
        }

        for (int i = 0; i < letters.length; i++) {
            if (min == letters[i]) {
                s = s.replace(Character.toString((char) (i + 97)), "");
            }
        }

        System.out.println(s);
    }

    /**
     * todo
     * 插入排序
     * 输入：
     * A Famous Saying: Much Ado About Nothing (2012/8).
     * 输出：
     * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
     */
    public static void test26() {
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.nextLine();

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                list.add(c);
            }
        }

        list.sort((o1, o2) -> {
            return Character.toLowerCase(o1) - Character.toLowerCase(o2);
        });

        String strNew = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                strNew += list.get(count);
                count++;
            } else {
                strNew += str.substring(i, i + 1);
            }
        }
        System.out.println(strNew);
    }

    public static void test27() {
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.nextLine();

        String[] s = str.split(" ");
        String sourceletter = s[s.length - 2];

        List<String> list = new ArrayList<>();

        for (int i = 1; i < s.length - 2; i++) {
            if (isBroLetter(sourceletter, s[i]) && !sourceletter.equals(s[i])) {
                list.add(s[i]);
            }
        }

        list.sort(Comparator.comparing(String::toString));

        Integer integer = Integer.valueOf(s[s.length - 1]);
        System.out.println(list.size());
        if (integer <= list.size()) {
            System.out.println(list.get(integer - 1));
        }
    }

    public static boolean isBroLetter(String sourceletter, String targetLetter) {
        int length1 = sourceletter.length();
        int length2 = sourceletter.length();

        if (length1 != length2) {
            return false;
        }
        return orderByletter(sourceletter).equals(orderByletter(targetLetter));
    }

    public static String orderByletter(String letter) {
        char[] chars = letter.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i] + "");
        }
        list.sort(Comparator.comparing(String::toString));

        return list.stream().collect(Collectors.joining(""));
    }

    /**
     * 判断字符是否需要排序
     *
     * @return
     */
    public static boolean checkLetterIsSort(String str) {
        char c = str.charAt(0);
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public static void test29() {
        Scanner sc1 = new Scanner(System.in);
        String encode = sc1.nextLine();
        String decode = sc1.nextLine();

        System.out.println(encode(encode));
        System.out.println(decode(decode));
    }

    public static void test30() {
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.nextLine();

        String str1 = str.split(" ")[0];
        String str2 = str.split(" ")[1];
        String strNew = str1 + str2;

        Map<String, String> map = new HashMap<>();
        map.put("0", "0");
        map.put("1", "8");
        map.put("2", "4");
        map.put("3", "C");
        map.put("4", "2");
        map.put("5", "A");
        map.put("6", "6");
        map.put("7", "E");
        map.put("8", "1");
        map.put("9", "9");
        map.put("A", "5");
        map.put("B", "D");
        map.put("C", "3");
        map.put("D", "B");
        map.put("E", "7");
        map.put("F", "F");
        List<Character> character1 = new ArrayList<>();
        List<Character> character2 = new ArrayList<>();

        for (int i = 0; i < strNew.length(); i++) {
            if (i % 2 == 0) {
                character1.add(strNew.charAt(i));
            } else {
                character2.add(strNew.charAt(i));
            }
        }

        character1 = character1.stream().sorted((o1,o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        character2 = character2.stream().sorted((o1,o2) -> o1.compareTo(o2)).collect(Collectors.toList());

        String newStr = "";
        for (int i = 0; i < strNew.length(); i++) {
            String key = "";
            if (i % 2 == 0) {
                key = Character.toString(character1.get(i / 2)).toUpperCase();
                if(map.containsKey(key)) {
                    newStr += map.get(key);
                } else {
                    newStr += character1.get(i / 2);
                }
            } else {
                key = Character.toString(character2.get((i - 1) / 2)).toUpperCase();
                if(map.containsKey(key)) {
                    newStr += map.get(key);
                } else {
                    newStr += character2.get((i - 1) / 2);
                }
            }
        }

        System.out.println(newStr);
    }

    public static String encode(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('0' <= c && c < '9') {
                newStr += Character.toString((char) (c + 1));
            } else if (c == '9') {
                newStr += "0";
            } else if ('a' <= c && c < 'z') {
                newStr += Character.toString((char) (c - 31));
            } else if (c == 'z') {
                newStr += "A";
            } else if ('A' <= c && c < 'Z') {
                newStr += Character.toString((char) (c + 33));
            } else if (c == 'Z') {
                newStr += "a";
            } else {
                newStr += str.substring(i, i + 1);
            }
        }
        return newStr;
    }

    public static String decode(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('0' < c && c <= '9') {
                newStr += Character.toString((char) (c - 1));
            } else if (c == '0') {
                newStr += "9";
            } else if ('a' < c && c <= 'z') {
                newStr += Character.toString((char) (c - 33));
            } else if (c == 'a') {
                newStr += "Z";
            } else if ('A' < c && c <= 'Z') {
                newStr += Character.toString((char) (c + 31));
            } else if (c == 'A') {
                newStr += "z";
            } else {
                newStr += str.substring(i, i + 1);
            }
        }
        return newStr;
    }
}
