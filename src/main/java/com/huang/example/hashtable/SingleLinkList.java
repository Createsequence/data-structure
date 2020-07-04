package com.huang.example.hashtable;

/**
 * @Author：黄成兴
 * @Date：2020-06-20 10:19
 * @Description：单链表
 */
public class SingleLinkList {

    private Node head = new Node(0);

    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 添加节点到链表
     * @param node 要插入的节点
     */
    public void add(Node node) {
        Node temp = head;
        //遍历链表
        while (true) {
            if (temp.next == null) {
                break;
            }
            //不是尾节点就继续遍历下一个节点
            temp = temp.next;
        }
        //将尾节点指向即将插入的新节点
        temp.next = node;
    }

    /**
     * 展示链表
     */
    public void show() {
        //判断链表是否为空
        if (isEmpty()) {
            return;
        }
        Node temp = head.next;
        //遍历链表
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    /**
     * 根据序号获取节点
     * @param num 要获取的节点序号
     * @return
     */
    public Node get(int num){
        //判断链表是否为空
        if (isEmpty()) {
            return null;
        }
        Node temp = head.next;
        //遍历链表
        while (true) {
            if (temp == null) {
                return null;
            }
            if (temp.num == num) {
                return temp;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改节点
     * @param node 要更新的节点
     */
    public void update(Node node) {
        Node temp = head;
        //判断链表是否为空
        if (isEmpty()) {
            return;
        }
        //获取要更新的节点序号
        int nodeNum = node.num;
        //遍历链表
        while (true) {
            //如果已经遍历完链表
            if (temp == null) {
                throw new RuntimeException("编号为" + temp.num + "的节点不存在！");
            }
            //如果找到了该节点
            if (temp.num == nodeNum) {
                return;
            }
            //继续遍历下一节点
            temp = temp.next;
        }
    }

    /**
     * 删除节点
     * @param num 要删除的节点编号
     */
    public void delete(int num) {
        Node temp = head;
        //判断链表是否为空
        if (isEmpty()) {
            return;
        }
        //遍历链表
        while (true) {
            //如果链表到底了
            if (temp.next == null) {
                return;
            }
            //如果找到了待删除节点的前一个节点
            if (temp.next.num == num) {
                //判断待删除节点是否为尾节点
                if (temp.next.next == null){
                    temp.next = null;
                }else {
                    temp.next = temp.next.next;
                }
                return;
            }
            //继续遍历下一节点
            temp = temp.next;
        }
    }
}
