package com.huang.example.search;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-07-01 20:02
 * @Description：查找算法测试
 */
public class searchTest {

    //生成的测试数组长度
    static int max = 8000;
    static int[] arr = new int[max];
    static int target = 0;

    /**
     * 在所有测试用例运行前生成有序数列表
     */
    @BeforeClass
    public static void setStartTimeAndTestArr() {
        //生成max个有序数
        for (int i = 0; i < max; i++) {
            arr[i] = i;
        }
        //生成一个随机目标
        target = (int) (Math.random() * max);
        System.out.println("查找元素：" + target);
        System.out.println();
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
    public void testLinearSearch(){
        Long startTime = getFunctionStartTime();
        LinearSearch.search(arr,target);
        getFunctionRunningTime("线性查找", startTime);
    }

    @Test
    public void testBinarySearch(){
        Long startTime = getFunctionStartTime();
        BinarySearch.search(arr,target);
        getFunctionRunningTime("二分查找", startTime);
    }

    @Test
    public void testInsertSearch(){
        Long startTime = getFunctionStartTime();
        InsertSearch.search(arr,target);
        getFunctionRunningTime("插值查找", startTime);
    }

    @Test
    public void testFibonacciSearch(){
        Long startTime = getFunctionStartTime();
        FibonacciSearch.search(arr,target);
        getFunctionRunningTime("斐波那契查找", startTime);
    }
}
