package com.huang.example.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：CreateSequence
 * @Date：2020-07-16 20:52
 * @Description：<描述>
 */
public class HeapSortTest {

    @Test
    public void testHeapSort() {
        int[] arr = {4, 6, 8, 5, 9, 22, 62, 1, 3};
        System.out.println(Arrays.toString(HeapSort.sort(arr)));
    }

}
