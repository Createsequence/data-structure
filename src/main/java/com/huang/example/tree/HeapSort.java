package com.huang.example.tree;

/**
 * @Author：CreateSequence
 * @Date：2020-07-16 16:53
 * @Description：堆排序
 */
public class HeapSort {

    /**
     * 对数组进行堆排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        //将无序数组构建成一个大/小顶堆
        //有几个非叶子节点就排序几次
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            sortHeap(arr,i,arr.length);
        }

        int temp = 0;
        //交换数组头尾元素，将最大的元素排沉到队尾
        for (int i = arr.length - 1; i > 0; i--) {
            //交换头尾元素
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //1.此时最大的元素在arr[0]，最小的元素在arr[i]，即确定了本次排序范围最大的数
            //2.然后对0~i-1的范围进行排序，重新获得的数组最小的元素在arr[0]，最大的元素在arr[i-1]
            //3.接着进入下一次循环，重复步骤1，2，每次循环排序范围都缩小一位
            sortHeap(arr, 0, i);
        }

        return arr;
    }

    /**
     * 将以非叶子节点i为根节点的树调整为一个大顶堆
     * @param arr 要调整的数组
     * @param i 非叶子结点在数组中的下标
     * @param length 要调整的数组长度
     */
    public static int[] sortHeap(int[] arr, int i, int length) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("数列必须至少有一个元素！");
        }

        //获取根节点值
        int temp = arr[i];

        //从左节点开始遍历
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            //比较左右节点大小，将j指向值大的节点
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j = j + 1;
            }
            //比较将左右节点与父节点大小
            if (arr[j] > temp) {
                //如果子节点大于父节点，交换两节点位置
                arr[i] = arr[j];
                //然后继续从该子节点向下遍历
                i = j;
            }else {
                break;
            }
        }

        //结束循环时，arr[i]已经存放了以原arr[i]为根节点的树的最大值
        arr[i] = temp;

        return arr;
    }

}
