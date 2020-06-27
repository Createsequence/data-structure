package com.huang.example.sort;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-06-27 23:09
 * @Description：插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {-1, 52, 9, 13, -5, 7};
        sort(arr);
    }

    /**
     * 输入一串无序数组，对其进行插入排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        //需要从第二位开始，避免i-1出现控制针
        for (int i = 1; i < arr.length; i++) {
            //指向当前插入位置前一个元素的指针
            int pre = i - 1;
            //当前处理元素的值
            int val = arr[i];

            // 让比当前元素大的元素不断的后移，直到到头了或者找到了比当前元素小的元素
            while (pre >= 0 && arr[pre] > val) {
                //前一个元素往后移
                arr[pre + 1] = arr[pre];
                //继续往前移动
                pre--;
            }

            //跳出循环时即找到了当前元素的正确插入位置
            //将该位置的值赋成处理元素的值
            arr[pre + 1] = val;

            //System.out.println("第" + (i + 1) + "轮：" + Arrays.toString(arr));
        }

        return arr;
    }

}
