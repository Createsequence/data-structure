package com.huang.example.huffman;

/**
 * @Author：CreateSequence
 * @Date：2020-07-17 17:31
 * @Description：赫夫曼树使用的节点
 */
public class Node implements Comparable<Node> {

    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    /**
     * 父节点的构造方法
     * @param left
     * @param right
     */
    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        this.val = left.val + right.val;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }

    /**
     * 实现排序接口，从大到小
     * @param o
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return -(this.val - o.val);
    }
}
