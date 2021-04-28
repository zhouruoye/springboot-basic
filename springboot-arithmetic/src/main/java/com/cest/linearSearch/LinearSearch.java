package com.cest.linearSearch;

/**
 * 线性查找
 * 算法输入：数组（或其他数据结构）和目标元素
 * 算法输出：目标元素所在索引；若不存在，则返回-1
 */
public class LinearSearch {

    private LinearSearch() {

    }


    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if(data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 改进版 -- 使用泛型
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {20,10,25,16,8};
        int res = LinearSearch.search(data, 16);
        System.out.println(res);//3

        int res2 = LinearSearch.search(data, 1);
        System.out.println(res2);//-1
    }
}
