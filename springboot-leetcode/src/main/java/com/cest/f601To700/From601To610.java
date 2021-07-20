package com.cest.f601To700;

import java.util.regex.Pattern;

public class From601To610 {

    private int size;
    private String realCompressedString;

//["StringIterator","next","next","next","next","next","next","hasNext","next","hasNext"]
//        [["L10e2t1C1o1d1e11"],[],[],[],[],[],[],[],[],[]]
    public From601To610(String compressedString) {
        //判断是否是整数
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        String newcompressedString = "";
        String tmp = "";
        int count = 0;
        int length = compressedString.length();
        while(count <= length-1) {
            String substring = compressedString.substring(count, count + 1);
            if(pattern.matcher(substring).matches()) {
                for (int i = 0; i < Integer.parseInt(substring)-1; i++) {
                    newcompressedString +=  tmp;
                }
            } else {
                newcompressedString += substring;
                tmp = substring;
            }
            count++;
        }
        this.realCompressedString = newcompressedString;
        this.size = 0;
    }


    public char next() {
        if(size < realCompressedString.length()) {
            return realCompressedString.charAt(size++);
        }
        return ' ';
    }

    public boolean hasNext() {
        return !(realCompressedString.length() == size);
    }

    public static void main(String[] args) {
        From601To610 from601To610 = new From601To610("L10e2t1C1o1d1e11");
        System.out.println(from601To610.next());
        System.out.println(from601To610.next());
        System.out.println(from601To610.next());
        System.out.println(from601To610.next());
        System.out.println(from601To610.next());
        System.out.println(from601To610.next());
        System.out.println(from601To610.next());
        System.out.println(from601To610.hasNext());
        System.out.println(from601To610.next());
        System.out.println(from601To610.hasNext());
        System.out.println(from601To610.next());
    }
}
