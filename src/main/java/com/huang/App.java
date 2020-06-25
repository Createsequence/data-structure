package com.huang;

import com.huang.example.stack.LinkListStack;

import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        LinkListStack linkListStack = new LinkListStack();
        linkListStack.push("一号");
        linkListStack.push("二号");
        linkListStack.push("三号");
        linkListStack.push("四号");


        System.out.println(linkListStack.pop());
        System.out.println(linkListStack.pop());

        System.out.println();
        linkListStack.show();

    }
}
