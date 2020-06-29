package com.huang.example.sort;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-06-29 21:45
 * @Description：归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {-1, 52, 9, 13, -5, 7};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        int temp[] = new int[arr.length];
        return sort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 合并排序
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param right 右边索引
     * @param temp 临时存储的中转数组
     */
    public static int[] sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            //获取中间索引
            int mid = (left + right) / 2;
            //向左递归分解
            sort(arr, left, mid, temp);
            //向右递归分解
            sort(arr, mid + 1, right, temp);
            // 先左遍历到最左边，然后向右遍历，当l=r时触发排序
            merge(arr, left, mid, right, temp);
        }
        return arr;
    }

    /**
     * 合并的方法
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 临时存储的中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左边有序序列的初始索引
        int i = left;
        //中间索引
        int j = mid+1;
        //temp的索引
        int t = 0;

        //先把左右两边有序的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素小于等于右边有序序列的当前元素
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                //否则将右边有序序列的当前元素填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //左边的有序序列还有剩余的元素，就全部填充到temp数组
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        //右边的有序序列还有剩余的元素，就全部填充到temp数组
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //将temp数组里的有序元素拷贝回arr数组
        //从左边开始拷贝， 注意：不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //第一次合并：templeft = 0，right = 1。 第二次合并：templeft = 2，right = 3。 最后一次：templeft = 0，right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
