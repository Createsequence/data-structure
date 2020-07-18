package com.huang.example.huffman;

/**
 * @Author：CreateSequence
 * @Date：2020-07-18 13:28
 * @Description：赫夫曼编码用节点
 */
public class HuffmanCodeNode implements Comparable<HuffmanCodeNode>{

    //字符
    Byte data;
    //权值
    int weight;
    HuffmanCodeNode left;
    HuffmanCodeNode right;

    public HuffmanCodeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public HuffmanCodeNode(HuffmanCodeNode left, HuffmanCodeNode right) {
        //计算子节点权值之和
        this.weight = left.weight + right.weight;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    
}
