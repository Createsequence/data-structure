package com.huang.example.queue;

/**
 * @Author：黄成兴
 * @Date：2020-06-11 16:28
 * @Description：用数组模拟队列
 */
public class Queue {

    //队列最大长度
    private int maxSize;
    //存放数据的数组
    private Object[] arr;
    //头指针，指向队头的元素的前一个位置
    private int front;
    //尾指针，指向队尾的元素所在位置
    private int rear;

    //构造器
    public Queue(int size) {
        this.maxSize = size;
        this.arr = new Object[maxSize];
        this.front = -1;
        this.rear = -1;
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
        //当尾指针等于maxSize-1时队列满
        return rear == maxSize - 1;
    }

    /**
     * 入队
     * @param item 入队元素
     * @return
     */
    public int addQueue(Object item) {
        //判断队列是已满还是只是尾指针到头
        if (isFull()) {
            //如果队列已满
            if (front == -1){
                throw new RuntimeException("队列已满！");
            }
            //尾指针到头，触发数据迁移
            System.out.println("尾指针到头，触发数据迁移！当前有元素" + (rear - front) + "个");
            for (int i = front; i < rear; i++) {
                arr[i - front] = arr[i];
            }
            //移动指针
            rear -= front;
            front = -1;
        }
        //尾指针后移
        rear++;
        arr[rear] = item;
        System.out.println("入队" + item);
        return rear;
    }

    /**
     * 出队
     * @return
     */
    public Object quitQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        //头指针后移
        front++;
        return arr[front];
    }

}
