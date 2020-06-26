package com.huang.example.linklist;

import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 11:50
 * @Description：单链表测试代码
 */
public class SingkeLinkListTest {
    SingleLinkList singleLinkList = new SingleLinkList();

    Node node4 = new Node(4, "四号");
    Node node2 = new Node(2, "二号");
    Node node1 = new Node(1, "一号");
    Node node3 = new Node(3, "三号");

    @Test
    public void testAdd() {
        singleLinkList.add(node1);
        singleLinkList.add(node2);
        singleLinkList.add(node3);
        singleLinkList.add(node4);

        singleLinkList.show();
    }

    @Test
    public void testAddByOrder() {
        singleLinkList.addByOrder(node1);
        singleLinkList.addByOrder(node2);
        singleLinkList.addByOrder(node3);
        singleLinkList.addByOrder(node4);

        singleLinkList.show();
    }

    @Test
    public void testGet(){
        singleLinkList.add(node1);
        singleLinkList.add(node2);
        singleLinkList.add(node3);
        singleLinkList.add(node4);

        System.out.println(singleLinkList.get(2));
    }

    @Test
    public void testUpdata() {
        singleLinkList.add(node1);
        singleLinkList.add(node2);
        singleLinkList.add(node3);
        singleLinkList.add(node4);

        System.out.println(singleLinkList.get(4));
        System.out.println("------更新后-------");

        singleLinkList.update(new Node(4,"新四号节点"));
        System.out.println(singleLinkList.get(4));
    }

    @Test
    public void testDelete() {
        singleLinkList.add(node1);
        singleLinkList.add(node2);
        singleLinkList.add(node3);
        singleLinkList.add(node4);

        singleLinkList.delete(2);
        singleLinkList.show();
    }
}
