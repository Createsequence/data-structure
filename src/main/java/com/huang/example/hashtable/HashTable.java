package com.huang.example.hashtable;

import java.util.Arrays;

/**
 * @Author：黄成兴
 * @Date：2020-07-04 11:36
 * @Description：哈希表
 */
public class HashTable {

    //数组长度
    private int size;
    //用于存放数据的数组
    private SingleLinkList[] arr;

    public HashTable(int size) {
        this.size = size;
        //初始化数组
        arr = new SingleLinkList[size];
        //初始化链表
        for (int i = 0; i < size; i++) {
            arr[i] = new SingleLinkList();
        }
    }

    /**
     * 获取哈希值
     * @param item
     * @return
     */
    public int getHashCode(int item) {
        return item % 2;
    }

    /**
     * 插入元素
     * @param item
     */
    public void insert(int item) {
        //获取哈希值
        int hashCode = getHashCode(item);
        //判断哈希值是否超过数组范围
        if (hashCode >= size || hashCode < 0) {
            throw new RuntimeException("哈希值：" + hashCode + "超出初始化长度！");
        }
        //如果该元素在链表中不存在就插入
        if (arr[hashCode].isEmpty() || arr[hashCode].get(item) == null) {
            //插入元素
            arr[hashCode].add(new Node(item));
        }else {
            //否则就更新
            arr[hashCode].update(new Node(item));
        }

    }

    /**
     * 查找元素
     * @param item
     */
    public Node get(int item) {
        //获取哈希值
        int hashCode = getHashCode(item);
        //判断哈希值是否超过数组范围
        if (hashCode >= size || hashCode < 0) {
            return null;
        }
        //查找元素
        return arr[hashCode].get(item);
    }

    /**
     * 删除元素
     * @param item
     */
    public void delete(int item) {
        //获取哈希值
        int hashCode = getHashCode(item);
        //删除元素
        arr[hashCode].delete(item);
    }

    /**
     * 展示某个哈希值对应链表的全部数据
     * @param item
     */
    public void show(int item) {
        //获取哈希值
        int hashCode = getHashCode(item);
        arr[hashCode].show();
    }

    /**
     * 展示哈希表的所有数据
     */
    public void showAll() {
        for (int i = 0; i < arr.length; i++) {
            //只展示非空链表
            if (!arr[i].isEmpty()) {
                System.out.println("第"+i+"条链表：");
                arr[i].show();
            }
        }
    }

}
