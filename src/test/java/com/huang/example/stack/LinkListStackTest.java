package com.huang.example.stack;

import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 12:46
 * @Description：<描述>
 */
public class LinkListStackTest {

    LinkListStack linkListStack = new LinkListStack();

    @Test
    public void testPush() {
        linkListStack.push("一号");
        linkListStack.push("二号");
        linkListStack.push("三号");
        linkListStack.push("四号");

        linkListStack.show();
    }

    @Test
    public void testPop() {
        linkListStack.push("一号");
        linkListStack.push("二号");
        linkListStack.push("三号");
        linkListStack.push("四号");

        System.out.println(linkListStack.pop());
        System.out.println(linkListStack.pop());
        System.out.println(linkListStack.pop());
        System.out.println(linkListStack.pop());
    }


}
