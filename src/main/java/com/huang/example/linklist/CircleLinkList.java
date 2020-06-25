package com.huang.example.linklist;

/**
 * @Author：黄成兴
 * @Date：2020-06-21 17:50
 * @Description：环形链表
 */
public class CircleLinkList {

    private Node head = new Node(0, "我是头结点");

    /**
     * 构建环形链表
     * @param node
     */
    public void create(int num) {
        if (num < 1) {
            throw new RuntimeException("链表节点数量必须大于0");
        }
        //尾指针，用于辅助创建链表
        Node tail = null;
        //创建链表
        for (int i = 1; i <= num; i++) {
            Node node = new Node(i, i + "号节点");
            //如果是第一个元素
            if (i == 1) {
                head.next = node;
                tail.next = head;
                tail = node;
            }else {
                //如果不是第一个元素
                tail.next = node;
                node.next = head;
                tail = node;
            }
        }
    }

}