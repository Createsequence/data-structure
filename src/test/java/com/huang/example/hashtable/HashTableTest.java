package com.huang.example.hashtable;

import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-07-04 11:57
 * @Description：<描述>
 */
public class HashTableTest {

    HashTable hashTable = new HashTable(5);

    @Test
    public void testInsert() {
        hashTable.insert(1);
        hashTable.insert(2);
        hashTable.insert(3);
        hashTable.insert(2);
        hashTable.insert(3);

        hashTable.showAll();
    }

    @Test
    public void testDelete() {
        hashTable.insert(1);
        hashTable.insert(2);
        hashTable.delete(3);

        hashTable.delete(2);
        hashTable.showAll();
    }

    @Test
    public void testGet() {
        hashTable.insert(4);
        System.out.println(hashTable.get(4));
    }

}
