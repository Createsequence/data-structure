package com.huang.example.sort;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-06-27 19:59
 * @Description：冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {-1, 52, 9, 13, -5, 7};
        sort(arr);
    }

    /**
     * 输入一串无序数组，对其进行冒泡排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        //如果某次排序不发生交换，说明已经为有序
        boolean isChange = false;

        //根据数组长度决定一共需要排序几次
        int round = arr.length - 1;
        for (int i = 0; i < round; i++) {
            //每次排序需要对比到第几位
            for (int j = 0; j < round - i; j++) {
                //对比大小
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    //发生交换
                    isChange = true;
                }
            }

            //判断本次排序是否发生交换
            if (!isChange) {
                System.out.println("第" + (i + 1) + "次排序无交换，第" + i + "次排序已为有序！");
                return arr;
            }else {
                isChange = false;
            }

            //System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
        return arr;
    }

}
