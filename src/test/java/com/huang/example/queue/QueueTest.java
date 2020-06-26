package com.huang.example.queue;

import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 11:51
 * @Description：队列测试代码
 */
public class QueueTest {

    Queue queue = new Queue(5);

    @Test
    public void testAddWhenFull() {
        queue.addQueue("一号");
        queue.addQueue("二号");
        queue.addQueue("三号");
        queue.addQueue("四号");
        queue.addQueue("五号");
        queue.addQueue("六号");
    }

    @Test
    public void testQuitWhenEmpty() {
        queue.quitQueue();
    }

    @Test
    public void testAddALLAndQuitAll() {
        queue.addQueue("一号");
        queue.addQueue("二号");
        queue.addQueue("三号");
        queue.addQueue("四号");
        queue.addQueue("五号");

        System.out.println("------出队-----");

        System.out.println(queue.quitQueue());
        System.out.println(queue.quitQueue());
        System.out.println(queue.quitQueue());
        System.out.println(queue.quitQueue());
        System.out.println(queue.quitQueue());
    }

    @Test
    public void testQuitAfterAddAndQuit() {

        queue.addQueue("一号");
        queue.addQueue("二号");
        queue.addQueue("三号");
        queue.addQueue("四号");
        queue.addQueue("五号");

        System.out.println("------出队-----");

        System.out.println(queue.quitQueue());
        System.out.println(queue.quitQueue());
        System.out.println(queue.quitQueue());
        System.out.println(queue.quitQueue());
        System.out.println(queue.quitQueue());

        System.out.println("------尝试指针到底后是否触发数据迁移-----");
        queue.addQueue("一号");
    }

}
