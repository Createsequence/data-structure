package com.huang.example.huffman;

import org.junit.Test;

/**
 * @Author：CreateSequence
 * @Date：2020-07-17 18:03
 * @Description：<描述>
 */
public class HuffmanTreeTest {

    @Test
    public void createTest(){
        int[] arr = {13, 7, 8, 3, 26, 6, 1};
        System.out.println(HuffmanTree.create(arr));
    }

}
