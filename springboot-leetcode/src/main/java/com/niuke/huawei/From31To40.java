package com.niuke.huawei;

import java.util.*;
import java.util.stream.Collectors;

public class From31To40 {

    public static void main(String[] args) {
//        test31();

//        test33();

//        test34();

        test39();
    }

    public static void test31() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll("[^\\w]", " ").trim();
        String[] s1 = s.split(" ");
        List<String> list = Arrays.asList(s1);
        Collections.reverse(list);
        String collect = list.stream().collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    public static void test33() {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String number = sc.nextLine();
        System.out.println(ipToNumber(ip));
        System.out.println(NumberToIp(number));
    }

    public static void test34() {
        Scanner sc = new Scanner(System.in);
        String pic = sc.nextLine();
        int[] ints = new int[128];

        for (int i = 0; i < pic.length(); i++) {
            int i1 = pic.charAt(i) + 0;
            ints[i1] = ints[i1] + 1;
        }
        String str = "";
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] == 0) {
                continue;
            }

            for (int i1 = 0; i1 < ints[i]; i1++) {
                char i2 = (char) (i);
                str += i2;
            }
        }
        System.out.println(str);
    }

    public static void test35() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        List<String> list = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
            List<String> newlist = new ArrayList<>();
            int n = i - i1;

        }

    }

    public static void test36() {

    }

    public static void test37() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[] nums = new int[i+1];
        nums[1] = 1;
        nums[2] = 1;

        for (int i1 = 3; i1 <= i; i1++) {
            nums[i1] = nums[i1-1] + nums[i1-2];
        }

        System.out.println(nums[i]);
    }

    public static void test38() {
        Scanner sc = new Scanner(System.in);
        double v = sc.nextDouble();
        System.out.println(v * 2.875);
        System.out.println(v * 0.03125);
    }

    public static void test39() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String subNetMask = sc.nextLine();
            String ipOne = sc.nextLine();
            String ipTwo = sc.nextLine();

            if(!isLegalSubmitMask(subNetMask)) {
                System.out.println("1");
                continue;
            }

            if(!isLegalIp(ipOne)) {
                System.out.println("1");
                continue;
            }

            if(!isLegalIp(ipTwo)) {
                System.out.println("1");
                continue;
            }

            String subNet1 = getSubNet(subNetMask, ipOne);
            String subNet2 = getSubNet(subNetMask, ipTwo);
            if(subNet1.equals(subNet2)) {
                System.out.println("0");
                continue;
            } else {
                System.out.println("2");
                continue;
            }
        }
    }

    public static String getSubNet(String subNetMask,String ip) {
        String[] subNets = subNetMask.split("\\.");
        String[] ips = ip.split("\\.");

        String str = "";
        for (int i = 0; i < subNets.length; i++) {
            str += Integer.parseInt(subNets[i]) & Integer.valueOf(ips[i]);
        }
        return str;
    }

    public static boolean isLegalSubmitMask(String subNetMask) {
        String[] split = subNetMask.split("\\.");

        if(split.length != 4) {
            return false;
        }

        for (int i = 0; i < split.length; i++) {
            int num = Integer.valueOf(split[i]);
            if(num < 0 || num > 255) {
                return false;
            }

            if(num > 0 && num < 255) {
                if(!isLegalBinrySubNet(num)) {
                    return false;
                }
            }

            if(i > 0) {
                if(!"0".equals(split[i]) && "0".equals(split[i-1])) {
                    return false;
                }

                if("255".equals(split[i]) && !"255".equals(split[i-1])) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isLegalBinrySubNet(Integer num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if((num&1) == 0) {
                list.add(0);
            } else {
                list.add(1);
            }
            num = num >> 1;
        }

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) == 0 && list.get(i-1) == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLegalIp(String ip) {
        String[] split = ip.split("\\.");
        if(split.length != 4) {
            return false;
        }

        for (int i = 0; i < split.length; i++) {
            int num = Integer.valueOf(split[i]);

            if(num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void test40() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String,Integer> map = new HashMap<>();
        map.put("eng",0);
        map.put("space",0);
        map.put("num",0);
        map.put("other",0);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(('A' <= c && c <= 'Z')||('a' <= c && c <= 'z')) {
                map.put("eng",map.get("eng")+1);
            }else if(' ' == c) {
                map.put("space",map.get("space")+1);
            }else if('0' <= c && c <= '9') {
                map.put("num",map.get("num")+1);
            }else {
                map.put("other",map.get("other")+1);
            }
        }

        System.out.println(map.get("eng"));
        System.out.println(map.get("space"));
        System.out.println(map.get("num"));
        System.out.println(map.get("other"));
    }

    public static String ipToNumber(String ip) {
        String[] split = ip.split("\\.");
        Long num = 0L;
        num += Long.parseLong(split[0]) * (1 << 24);
        num += Long.parseLong(split[1]) * (1 << 16);
        num += Long.parseLong(split[2]) * (1 << 8);
        num += Long.parseLong(split[3]);
        return String.valueOf(num);
    }

    public static String NumberToIp(String num) {
        Long targetNum = Long.parseLong(num);
        Long firstIp = targetNum >> 24;
        targetNum = targetNum - (firstIp << 24);
        Long secondIp = targetNum >> 16;
        targetNum = targetNum - (secondIp << 16);
        Long thridIp = targetNum >> 8;
        Long fourIp = targetNum - (thridIp << 8);
        return String.valueOf(firstIp) + "." + String.valueOf(secondIp) + "." + String.valueOf(thridIp) + "." + String.valueOf(fourIp);
    }
}
