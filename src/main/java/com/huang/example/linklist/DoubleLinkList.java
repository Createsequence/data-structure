package com.huang.example.linklist;

/**
 * @Author：huang
 * @Date：2020-06-21 11:04
 * @Description：双向链表
 */
public class DoubleLinkList {

    private Node head = new Node(0, "我是头结点");

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
        node.prev = temp;
    }

    /**
     * 展示链表
     */
    public void show() {
        //判断链表是否为空
        if (head.next == null) {
            throw new RuntimeException("链表为空！");
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
        if (head.next == null) {
            throw new RuntimeException("链表为空！");
        }
        Node temp = head.next;
        //遍历链表
        while (true) {
            if (temp == null) {
                throw new RuntimeException("编号为" + num + "的节点不存在！");
            }
            if (temp.num == num) {
                return temp;
            }
            temp = temp.next;
        }
    }

    /**
     * 按顺序添加节点到链表
     * @param node 要插入的节点
     */
    public void addByOrder(Node node) {
        Node temp = head;
        //遍历链表
        while (true) {
            //如果链表到底了就直接插入
            if (temp.next == null) {
                temp.next = node;
                node.prev = temp;
                return;
            }
            else if (temp.next.num > node.num){
                //如果后一节点比当新节点大，就插入当前节点
                node.prev = temp;
                node.next = temp.next;

                temp.next.prev = node;
                temp.next = node;
                return;
            }else if (temp.next.num == node.num){
                //如果后一节点等于新节点，抛异常
                throw new RuntimeException("插入节点与已有节点序号重复！");
            }
            //如果后一节点比当前节点小，就继续遍历
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
        if (temp.next == null) {
            throw new RuntimeException("链表为空！");
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
                temp.data = node.data;
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
        if (temp.next == null) {
            throw new RuntimeException("链表为空！");
        }
        //遍历链表
        while (true) {
            //如果链表到底了
            if (temp.next == null) {
                throw new RuntimeException("编号为" + num + "的节点不存在！");
            }
            //如果找到了待删除节点的前一个节点
            if (temp.num == num) {
                //判断待删除节点是否为尾节点
                if (temp.next == null){
                    temp.prev.next = null;
                }else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            //继续遍历下一节点
            temp = temp.next;
        }
    }

}
