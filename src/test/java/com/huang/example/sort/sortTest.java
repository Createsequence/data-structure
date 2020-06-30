package com.huang.example.sort;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-06-27 20:53
 * @Description：排序算法测试
 */
public class sortTest {

    //生成的测试数组长度
    static int max = 80000000;
    static int[] arr = new int[max];

    /**
     * 在所有测试用例运行前生成随机数列表
     */
    @BeforeClass
    public static void setStartTimeAndTestArr() {
        //生成max个随机数
        for (int i = 0; i < max; i++) {
            arr[i] = (int)(Math.random() * max);
        }
    }

    /**
     * 获取程序运行的开始时间
     * @return
     */
    public Long getFunctionStartTime(){
        return System.currentTimeMillis();
    }

    /**
     * 获取程序运行时间
     * @param funName
     * @param startTime
     */
    public void getFunctionRunningTime(String funName,Long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.println(funName + "运行结束，花费时间：" + (endTime - startTime) + "ms");
        System.out.println("------------------------");
    }

    @Test
    public void testBubbleSort(){
        Long startTime = getFunctionStartTime();
        BubbleSort.sort(arr);
        getFunctionRunningTime("冒泡排序", startTime);
    }

    @Test
    public void testSelectSort() {
        Long startTime = getFunctionStartTime();
        SelectSort.sort(arr);
        getFunctionRunningTime("选择排序", startTime);
    }

    @Test
    public void testInsertSort() {
        Long startTime = getFunctionStartTime();
        InsertSort.sort(arr);
        getFunctionRunningTime("插入排序", startTime);
    }

    @Test
    public void testShellSortByExchange(){
        Long startTime = getFunctionStartTime();
        ShellSort.sortByExchange(arr);
        getFunctionRunningTime("希尔排序（交换法）", startTime);
    }

    @Test
    public void testShellSortByMove(){
        Long startTime = getFunctionStartTime();
        ShellSort.sortByMove(arr);
        getFunctionRunningTime("希尔排序（移位法）", startTime);

    }

    @Test
    public void testQuickSort(){
        Long startTime = getFunctionStartTime();
        QuickSort.sort(arr);
        getFunctionRunningTime("快速排序", startTime);
    }

    @Test
    public void testMergeSort() {
        Long startTime = getFunctionStartTime();
        MergeSort.sort(arr);
        getFunctionRunningTime("归并排序", startTime);
    }

    @Test
    public void testRadixSort(){
        Long startTime = getFunctionStartTime();
        RadixSort.sort(arr);
        getFunctionRunningTime("基数排序", startTime);
    }

}
