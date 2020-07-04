package com.huang.example.search;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-07-01 21:12
 * @Description：<描述>
 */
public class FibonacciSearch {

    /**
     * 斐波那契数组长度
     */
    public final static int MAXSIZE = 20;

    public static void main(String[] args) {
        int[] arr = {2,8,9,33,35,50};
        System.out.println(search(arr,50));
    }

    /**
     * 获得一个斐波那契数列，用于提供数组分割点位置
     * @return
     */
    public static int[] getFibonacci() {
        int[] f = new int[MAXSIZE];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MAXSIZE; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target) {

        //数组第一位和最后一位下标
        int left = 0;
        int right = arr.length - 1;

        //斐波那契数列下标
        int k = 0;
        //生成的斐波那契数列
        int[] f = getFibonacci();

        //中间值
        int mid = 0;

        //获取离arr.length-1最近的分割点下标
        while (right > f[k] - 1) {
            k++;
        }
        //将数组长度延长到f[k]
        int[] temp = Arrays.copyOf(arr, f[k]);
        //将延长的那部分用原数组的最后一位填充
        for (int i = right + 1; i < f[k]; i++) {
            temp[i] = arr[right];
        }

        //查找目标数字
        while (left <= right) {
            //获取分割数组的中间点下标
            mid = left + f[k - 1] - 1;
            //如果元素在分割点的左边
            if (target < temp[mid]) {
                //向分割点左边查找
                right = mid - 1;
                //中间点右移到前一个分割点
                k--;
            } else if (target > temp[mid]) {
                //向分割点右边查找
                left = mid + 1;
                k-=2;
            }else {
                //找到要查找的数字
                //判断要返回的下标
                if (mid < right) {
                    return mid;
                }else {
                    return right;
                }
            }
        }
        return -1;
    }

}
