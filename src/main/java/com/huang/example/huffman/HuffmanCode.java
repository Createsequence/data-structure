package com.huang.example.huffman;

import java.util.*;

/**
 * @Author：CreateSequence
 * @Date：2020-07-18 13:26
 * @Description：赫夫曼编码
 */
public class HuffmanCode {

    private String str;

    public String getStr() {
        return str;
    }

    public HuffmanCode(String code) {
        if (code.length() == 0 || code == null) {
            throw new RuntimeException("字符串必须有至少一个字符！");
        }
        this.str = code;
    }

    /**
     * 统计字符在字符串中的出现次数，并组装节点列表
     * @return
     */
    public List<HuffmanCodeNode> getNodes() {
        //将字符串转为字符串数组
        byte[] bytes = str.getBytes();

        //遍历字节数组，并且统计某一字符出现次数
        Map<Byte, Integer> counts = new HashMap<>(24);
        for (byte b : bytes) {
            Integer count = counts.get(b);
            //判断某一字符是否第一次出现
            if (count == null) {
                counts.put(b, 1);
            }else {
                //不是就让出现次数+1
                counts.put(b, count ++);
            }
        }

        //将map转为节点集合
        List<HuffmanCodeNode> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanCodeNode(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    /**
     * 构建赫夫曼树
     * @param nodes
     * @return
     */
    private HuffmanCodeNode createTree(List<HuffmanCodeNode> nodes) {
        //构建树
        while (nodes.size() > 1) {
            //从小到大排序
            Collections.sort(nodes);
            //取出最小的两个数构建树
            HuffmanCodeNode left = nodes.get(0);
            HuffmanCodeNode right = nodes.get(1);
            HuffmanCodeNode parant = new HuffmanCodeNode(left, right);
            //删除两个节点
            nodes.remove(left);
            nodes.remove(right);
            //将根节点添加至集合
            nodes.add(parant);
        }
        //返回树的根节点
        return nodes.get(0);
    }
    public HuffmanCodeNode createTree(){
        return createTree(getNodes());
    }

    /**
     * 前序遍历
     * @param node 树的根节点
     */
    private void preOrder(HuffmanCodeNode node) {
        //递归
        System.out.println(node.toString());
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }
    public void preOrder(){
        HuffmanCodeNode root = createTree(getNodes());
        preOrder(root);
    }

    /**
     * 生成赫夫曼树对应的赫夫曼编码集合
     */
    private Map<Byte, String> huffmanCodes = new HashMap<>();
    /**
     * 储存某个叶子节点的拼接路径
     */
    private StringBuilder stringBuilder = new StringBuilder();

    /**
     * 将传入的节点作为树的根节点，找到其所有的叶子结点的赫夫曼编码，并放入赫夫曼编码集合
     * @param node 节点
     * @param way 叶子结点的路径，左为0，右为1
     * @param builder 用于拼接路径
     */
    private Map<Byte, String> getCodes(HuffmanCodeNode node, String way, StringBuilder builder) {
        StringBuilder stringBuilder = new StringBuilder(builder);
        //建路径拼接至上一路径
        stringBuilder.append(way);
        if (node != null) {
            //判断当前是否为叶子节点
            if (node.data == null) {
                //向左右递归直到找到叶子结点
                getCodes(node.left, "0", stringBuilder);
                getCodes(node.right, "1", stringBuilder);
            }else {
                //已经是叶子结点，将路径存入集合
                huffmanCodes.put(node.data, stringBuilder.toString());
            }
        }
        //返回赫夫曼编码
        return huffmanCodes;
    }

    public Map<Byte, String> getCodes() {
        //构建赫夫曼树
        HuffmanCodeNode root = createTree();
        //处理左右子树
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        //返回赫夫曼编码
        return huffmanCodes;
    }

    /**
     * 将字符串对应的byte数组，转换为经过赫夫曼编码压缩后的byte数组
     * @param bytes
     * @param huffmanCodes
     * @return
     */
    private byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //获取赫夫曼编码
        StringBuilder stringBuilder = new StringBuilder();
        //遍历byte数组，一个byte表示一个字符
        for (Byte b : bytes) {
            //将字符转为赫夫曼编码格式，一个字符对应8位编码
            stringBuilder.append(huffmanCodes.get(b));
        }

        //一个字符对应对应的8位的赫夫曼编码，如果赫夫曼编码无法被8整除，就直接补齐赫夫曼编码不足八位的那一个字符
        int len = stringBuilder.length() % 8 == 0 ? stringBuilder.length() / 8 : stringBuilder.length() / 8 + 1;
        //System.out.println("有几个字符："+len);

        //将压缩后的赫夫曼编码按字符分开存储
        byte[] huffmanCodeBytes = new byte[len];
        //计录已处理几个字符
        int index = 0;
        //每8位编码对应一个byte，所以步长为8
        //每循环一次处理一个byte，也就是一个字符
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strBytes;
            //判断编码长度是否超过8位
            if (i + 8 < stringBuilder.length()) {
                //超过8位就从赫夫曼编码截取八位（也就是一个字符）
                strBytes = stringBuilder.substring(i, i + 8);
            }else {
                //否则就有多少截多少
                strBytes = stringBuilder.substring(i);
            }
            //将赫夫曼编码转为二进制，存入byte数组
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strBytes, 2);

            //位已处理字符数+1
            index++;
        }

        //循环结束后，返回赫夫曼编码按字符转换得到的字节数组
        return huffmanCodeBytes;
    }
    public byte[] zip() {
        byte[] bytes = str.getBytes();
        Map<Byte, String> huffmanCodes = getCodes();
        return zip(bytes, huffmanCodes);
    }

}
