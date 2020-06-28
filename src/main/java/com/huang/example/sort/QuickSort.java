package com.huang.example.sort;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-06-28 20:46
 * @Description：快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-1, 52, 9, 9, 13, 9, -5, 7};
        System.out.println(Arrays.toString(sort(arr)));;
    }

    public static int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 输入一串无序数组，并根据给定的左右指针对指定的范围其进行排序
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] sort(int[] arr, int left, int right) {

        //左右指针
        int l = left;
        int r = right;

        //找到中间数
        int pivot = arr[(left + right) / 2];
        //用于元素交换的临时变量
        int temp;

        //将比中间数小的放左边，比中间数大的放右边
        while (l < r) {
            // 从左往右遍历，寻找大于等于中间数的数
            while (arr[l] < pivot) {
                l++;
            }
            // 从右往左遍历，寻找小于等于中间数的数
            while (arr[r] > pivot) {
                r--;
            }

            // 如果l > r，即左指针右指针都越过了中间数，说明两边数都已经有序
            // 如果l = r，即可能存在多个与中间数同值的元素的情况下，左右指针一起指向了同一边的同一个元素，也说明两边数都已经有序
            if (l >= r) {
                break;
            }

            //交换元素
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现现在右侧有一个与中间数相同的数，右指针前移一位
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现现在左侧有一个与中间数相同的数，左指针后移一位
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        //防止死循环
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向右递归
        if (left < r) {
            sort(arr, l, right);
        }
        //向左递归
        if (right > l) {
            sort(arr, left, r);
        }

        return arr;
    }

}
