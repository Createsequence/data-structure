package com.huang.example.search;

/**
 * @Author：黄成兴
 * @Date：2020-07-01 17:16
 * @Description：线性查找
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {2,8,9,50,33,35};
        System.out.println(search(arr,22));
    }

    /**
     * 在给定数组中线性查找指定元素
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr,int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
