package com.huang.example.linklist;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 11:54
 * @Description：双向链表测试代码
 */
public class DoubleLinkListTEst {

    DoubleLinkList doubleLinkList = new DoubleLinkList();

    Node node4 = new Node(4, "四号");
    Node node2 = new Node(2, "二号");
    Node node1 = new Node(1, "一号");
    Node node3 = new Node(3, "三号");

    @Test
    public void testAdd() {
        doubleLinkList.add(node1);
        doubleLinkList.add(node2);
        doubleLinkList.add(node3);
        doubleLinkList.add(node4);

        doubleLinkList.show();
    }

    @Test
    public void testAddByOrder() {
        doubleLinkList.addByOrder(node1);
        doubleLinkList.addByOrder(node2);
        doubleLinkList.addByOrder(node3);
        doubleLinkList.addByOrder(node4);

        doubleLinkList.show();
    }

    @Test
    public void testGet(){
        doubleLinkList.add(node1);
        doubleLinkList.add(node2);
        doubleLinkList.add(node3);
        doubleLinkList.add(node4);

        System.out.println(doubleLinkList.get(2));
    }

    @Test
    public void testUpdata() {
        doubleLinkList.add(node1);
        doubleLinkList.add(node2);
        doubleLinkList.add(node3);
        doubleLinkList.add(node4);

        System.out.println(doubleLinkList.get(4));
        System.out.println("------更新后-------");

        doubleLinkList.update(new Node(4,"新四号节点"));
        System.out.println(doubleLinkList.get(4));
    }

    @Test
    public void testDelete() {
        doubleLinkList.add(node1);
        doubleLinkList.add(node2);
        doubleLinkList.add(node3);
        doubleLinkList.add(node4);

        doubleLinkList.delete(2);
        doubleLinkList.show();
    }
}
