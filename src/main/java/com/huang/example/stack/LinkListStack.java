package com.huang.example.stack;

/**
 * @Author：黄成兴
 * @Date：2020-06-23 21:30
 * @Description：链表栈
 */
public class LinkListStack {

    private Node head = new Node("我是头结点");

    /**
     * 判断是否空栈
     * @return
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 添加节点到链表
     * @param item 要插入的元素
     */
    public void push(Object item) {
        Node node = new Node(item);
        Node temp = head;
        //如果空栈就直接插入
        if (isEmpty()) {
            temp.next = node;
            return;
        }

        //不是空栈就插到头结点头面
        node.next = temp.next;
        temp.next = node;
    }

    /**
     * 将元素出栈
     * @return 出栈元素
     */
    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        Node node = head.next;
        head.next = node.next;
        return node.data;
    }

    /**
     * 遍历栈
     */
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * @Author：huang
     * @Date：2020-06-20 10:19
     * @Description：节点
     */
    public class Node {

        //数据
        Object data;

        //下一个节点
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}