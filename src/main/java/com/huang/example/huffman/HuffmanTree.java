package com.huang.example.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author：CreateSequence
 * @Date：2020-07-17 17:37
 * @Description：赫夫曼树
 */
public class HuffmanTree {
    /**
     * 创建赫夫曼树
     * @param arr
     */
    public static List<Node> create(int[] arr){
        //将数组元素拆分成节点
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }

        //构建树
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);

            //取出最小的两个数构建树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parant = new Node(left, right);

            //删除两个节点
            nodes.remove(left);
            nodes.remove(right);

            //将根节点添加至集合
            nodes.add(parant);
        }

        return nodes;
    }

}
