package com.huang.example.queue;

import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 11:52
 * @Description：环形队列测试代码
 */
public class CricleQueueTest {

    CricleQueue cricleQueue = new CricleQueue(5);

    @Test
    public void testAddWhenFull() {
        cricleQueue.addQueue("一号");
        cricleQueue.addQueue("二号");
        cricleQueue.addQueue("三号");
        cricleQueue.addQueue("四号");
        cricleQueue.addQueue("五号");
        cricleQueue.addQueue("六号");
    }

    @Test
    public void testQuitWhenEmpty() {
        cricleQueue.quitQueue();
    }

    @Test
    public void testAddALLAndQuitAll() {
        cricleQueue.addQueue("一号");
        cricleQueue.addQueue("二号");
        cricleQueue.addQueue("三号");
        cricleQueue.addQueue("四号");
        cricleQueue.addQueue("五号");

        System.out.println("------出队-----");

        System.out.println(cricleQueue.quitQueue());
        System.out.println(cricleQueue.quitQueue());
        System.out.println(cricleQueue.quitQueue());
        System.out.println(cricleQueue.quitQueue());
        System.out.println(cricleQueue.quitQueue());
    }

    @Test
    public void testQuitAfterAddAndQuit() {

        cricleQueue.addQueue("一号");
        cricleQueue.addQueue("二号");
        cricleQueue.addQueue("三号");
        cricleQueue.addQueue("四号");
        cricleQueue.addQueue("五号");

        System.out.println("------出队3元素-----");
        cricleQueue.quitQueue();
        cricleQueue.quitQueue();
        cricleQueue.quitQueue();

        System.out.println("------入队3元素-----");
        cricleQueue.addQueue("三号");
        cricleQueue.addQueue("四号");
        cricleQueue.addQueue("五号");
    }

}
