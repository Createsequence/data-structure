package com.huang.example.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：黄成兴
 * @Date：2020-07-01 18:50
 * @Description：插值查找
 */
public class InsertSearch {

    public static void main(String[] args) {
        int[] arr = {2,8,9,33,35,50};
        System.out.println(search(arr,50));
    }

    /**
     * 查找所有值相等的元素
     * @param arr
     * @param target
     * @return
     */
    public static List<Integer> search(int[] arr,int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    /**
     * 插值查找
     * @param arr 查找的数字
     * @param left 左指针
     * @param right 右指针
     * @param target 查找目标
     * @return
     */
    public static List<Integer> search(int[] arr, int left, int right, int target) {
        ArrayList<Integer> targets = new ArrayList<>();

        //查询大小目标必须在数组范围内，防止arr[mid]时下标越界
        if (right < left || target > arr[arr.length - 1] || target < arr[0]) {
            return targets;
        }

        //获取中位数
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        //如果目标比中位数小，向左递归
        if (midVal > target) {
            return search(arr, left, mid - 1, target);
        } else if (midVal < target) {
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
            }

            return targets;
        }

    }

}
