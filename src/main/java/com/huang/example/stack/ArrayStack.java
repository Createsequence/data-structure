package com.huang.example.stack;

/**
 * @Author：黄成兴
 * @Date：2020-06-23 16:51
 * @Description：使用数组模拟栈
 */
public class ArrayStack {

    private int maxSize;
    private int top = -1;
    private Object[] arr;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new Object[maxSize];
    }

    /**
     * 判断栈满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Object item) {
        //判断栈是否已满
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        //入栈
        top = top + 1;
        arr[top] = item;
    }

    /**
     * 出栈
     */
    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        Object item = arr[top];
        top--;
        return item;
    }

    /**
     * 遍历栈
     */
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        //遍历并打印栈中元素
        for (int i = top; i >= 0; i--) {
            System.out.println("stack" + i + "：" + arr[i]);
        }
    }
}
