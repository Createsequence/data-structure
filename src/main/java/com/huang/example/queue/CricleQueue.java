package com.huang.example.queue;

/**
 * @Author：黄成兴
 * @Date：2020-06-14 16:13
 * @Description：环形链表
 */
public class CricleQueue {

    //队列最大长度
    private int maxSize;
    //存放数据的数组
    private Object[] arr;
    //头指针，指向队头的元素的位置
    private int front;
    //尾指针，指向队尾的元素的位置
    private int rear;

    public CricleQueue(int maxSize) {
        //由于需要在尾指针后空一位作为队满队空的区分，所以实际大小是maxSize+1
        this.maxSize = maxSize + 1;
        this.arr = new Object[maxSize + 1];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        //当头指针和尾指针相等时队列为空
        return rear == front;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        //头尾指针+1并取余时相等时队列满
        return (rear + 1) % maxSize == front;
    }

    /**
     * 入队
     * @param item
     */
    public void addQueue(Object item) {
        if (isFull()){
            throw new RuntimeException("队列已满！");
        }
        arr[rear] = item;
        rear = (rear + 1) % maxSize;
        System.out.println("入队" + item + "，当前尾指针：" + rear);
    }

    /**
     * 出队
     * @return
     */
    public Object quitQueue() {
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        Object item = arr[front];
        front = (front + 1) % maxSize;
        System.out.println("出队" + item + "，当前头指针：" + front);
        return item;
    }

}
