package com.huang.example.stack;

import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 11:51
 * @Description：<描述>
 */
public class ArrayStackTest {

    ArrayStack arrayStack = new ArrayStack(4);

    @Test
    public void testPush() {
        arrayStack.push("一号");
        arrayStack.push("二号");
        arrayStack.push("三号");
        arrayStack.push("四号");

        arrayStack.show();
    }

    @Test
    public void testPop() {
        arrayStack.push("一号");
        arrayStack.push("二号");
        arrayStack.push("三号");
        arrayStack.push("四号");

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }

}
