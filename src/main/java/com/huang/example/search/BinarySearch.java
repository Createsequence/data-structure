package com.huang.example.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：黄成兴
 * @Date：2020-07-01 17:24
 * @Description：二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,8,9,50,50,50,50,33,35};
        System.out.println(searchAll(arr, 2));
    }

    /**
     * 查找一个元素
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr,int target) {
        List<Integer> targets = search(arr, 0, arr.length, target);
        return targets.size() == 0 ? -1 : targets.get(0);
    }

    /**
     * 查找所有值相等的元素
     * @param arr
     * @param target
     * @return
     */
    public static List<Integer> searchAll(int[] arr,int target) {
        return search(arr, 0, arr.length, target);
    }

    /**
     * 二分查找
     * @param arr 查找的数字
     * @param left 左指针
     * @param right 右指针
     * @param target 查找目标
     * @return
     */
    public static List<Integer> search(int[] arr, int left, int right, int target) {
        ArrayList<Integer> targets = new ArrayList<>();

        //由于每次遍历右指针总是右移，左指针总是右移
        //所以当如果查找的是一个不存在的数时，即右指针小于左指针
        if (right < left) {
            return targets;
        }

        //获取中位数
        int mid = (right + left) / 2;

        //如果目标比中位数小，向左递归
        if (arr[mid] > target) {
            return search(arr, left, mid - 1, target);
        } else if (arr[mid] < target) {
            //如果目标表中位数打，向右递归
            return search(arr, mid + 1, right, target);
        } else {
            //如果找到了
            //向左查找相同的数
            int tempIndex = mid - 1;
            while (true){
                //到第一个数就不再继续找
                if(tempIndex < 0 || arr[tempIndex] != target){
                    break;
                }
                targets.add(tempIndex);
                tempIndex--;
            }
            //放入中间值
            targets.add(mid);
            //向右查找相同的数
            tempIndex = mid + 1;
            while (true) {
                //到最后一个数就不再继续找
                if(tempIndex > arr.length - 1 || arr[tempIndex] != target){
                    break;
                }
                targets.add(tempIndex);
                tempIndex++;
            }

            return targets;
        }

    }
}
