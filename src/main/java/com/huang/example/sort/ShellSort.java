package com.huang.example.sort;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-06-28 16:47
 * @Description：希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {-1, 52, 9, 13, -5, 7};
        sortByMove(arr);
    }

    /**
     * 输入一串无序数组，对其进行希尔排序
     *
     * 注意，此方法为移位法
     * 移位法即选择排序，仅仅遍历赋值后移动指针，找到插入位置后，再把元素插入到有序表，而不是多次交换加入有序表，比交换法快。
     *
     * @param arr
     * @return
     */
    public static int[] sortByMove(int[] arr) {
        int count = 0;
        // 将数组每次对半分分成多组，组数逐渐缩小
        // gap为每次分组后的同组元素的间隔，比如分成5组，那同组元素间隔即为5，即位置是i和i+5的元素是一组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //从第gap个元素开始，逐个对其所在组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                //如果某组最后一个元素比前一个元素小
                if (arr[j] < arr[j - gap]) {
                    //将同组元素不断后移，直到该元素找到位置或者到头为止
                    while (j - gap >= 0 && arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }

                    //当找到位置时插入元素
                    arr[j] = temp;
                }
            }

            //System.out.println("第" + (++count) + "轮：" + Arrays.toString(arr));

        }

        return arr;
    }

    /**
     * 输入一串无序数组，对其进行希尔排序
     * 注意，此方法为交换法
     * @param arr
     * @return
     */
    public static int[] sortByExchange(int[] arr) {
        int temp = 0;
        int count = 0;
        // 将数组每次对半分分成多组，组数逐渐缩小
        // gap为每次分组后的同组元素的间隔，比如分成5组，那同组元素间隔即为5，即位置是i和i+5的元素是一组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素开始，逐步遍历其所在的组，即从第一组开始向后遍历
            // 第gap个元素即为第一组的最后一个元素，也就是i即表示某组的最后一个位置
            for (int i = gap; i < arr.length; i++) {
                // 接着遍历同组元素，即一组有几个元素就遍历几次
                // j=i-gap即获得第某组的倒数第二个元素位置
                // 向前遍历，每隔gap个元素就对比一次大小
                for (int j = i - gap; j >= 0; j = j - gap) {
                    //如果当前元素大于后一个元素,就交换位置
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

            //System.out.println("第" + (++count) + "轮：" + Arrays.toString(arr));

        }

        return arr;
    }

}
