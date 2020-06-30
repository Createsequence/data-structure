package com.huang.example.sort;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-06-30 21:39
 * @Description：基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214 };
        System.out.println("最大位数：" + getMaxDigit(arr));
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 获取数组中的最大数的位数
     * @param arr
     * @return
     */
    public static int getMaxDigit(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return String.valueOf(max).length();
    }

    public static int[] sort(int[] arr) {
        //设置二维数组用于表示桶
        //第一层数组下标即表示存放某数位为x的数字的桶，比如下标为2的桶用于存放个位数为2的数字；下标为0的桶用于存放十位数为0的数字
        //第二层数组即表示桶高度
        int[][] bucket = new int[10][arr.length];

        //表示某个桶内用几个元素，比如bucketElementCount[0]即表示bucket[0]桶有几个元素
        //由于数字下标从0开始，所以这同时也表示了桶下一个元素的插入下标，比如bucketElementCount[0]=1，就意味着bucket[0]下一个元素应该插到bucket[0][1]去
        int[] bucketElementCount = new int[10];

        //最大数有几位就循环排序几次
        for (int i = 0, n = 1; i <= getMaxDigit(arr); i++, n *= 10) {
            //遍历元素并归类到桶中
            for (int j = 0; j < arr.length; j++) {
                //获取元素某数位的数字
                //根据遍历，获取数字的个位，十位数，百位数......
                int digitOfElement = arr[j] / n % 10;
                //将其归类到桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                //提高桶高度
                bucketElementCount[digitOfElement]++;
            }

            //按顺序将每一个桶中元素取出并放入原集合
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                //如果桶中有元素就取出
                if (bucketElementCount[k] != 0) {
                    //遍历桶中元素并放入数组
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //清空桶
                bucketElementCount[k] = 0;
            }
        }

        return arr;
    }

}
