package com.huang.example.huffman;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author：CreateSequence
 * @Date：2020-07-18 14:06
 * @Description：<描述>
 */
public class HuffmanCodeTest {

    public static HuffmanCode code = new HuffmanCode("i am a jvav programer,i love coding");

    @BeforeClass
    public static void print(){
        System.out.println("目前字节数："+code.getStr().length());
    }

    @Test
    public void testGetNode(){
        System.out.println(code.getNodes());
    }

    @Test
    public void testCreateTreeAndPreOrder(){
        code.preOrder();
    }

    @Test
    public void testGetCodes() {
        System.out.println(code.getCodes());
    }

    @Test
    public void testZip() {
        byte[] bytes = code.zip();
        System.out.println("压缩后字符长度：" + bytes.length);
        System.out.println(Arrays.toString(bytes));
        //[96, 26, 1, 7, -15, -16, -34, -59, -31, -92, -24, 96, -100, -12, 2, -61, 107, 5]
    }

}
