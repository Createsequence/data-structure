package com.huang.example.sort;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-06-27 21:18
 * @Description：选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {-1, 52, 9, 13, -5, 7};
        sort(arr);
    }

    /**
     * 输入一串无序数组，对其进行选择排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            //用于存放每次选择中最小数的下标，最小值默认为第一个数为i
            int minNumIndex = i;

            //从（i+1,arr.length）的范围中筛选最小的数
            for (int j = i + 1; j < arr.length; j++) {
                //如果范围内有数比现有minNum小，则替换下标
                if (arr[j] < arr[minNumIndex]) {
                    minNumIndex = j;
                }
            }
            //一次选择结束，将（i+1,arr.length）的范围中的最小数与arr[i]交换位置
            int temp = arr[minNumIndex];
            arr[minNumIndex] = arr[i];
            arr[i] = temp;

            //System.out.println("第" + (i + 1) + "轮：" + Arrays.toString(arr));
        }

        return arr;
    }

}
