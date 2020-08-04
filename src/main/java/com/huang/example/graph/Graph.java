package com.huang.example.graph;

import java.util.*;

/**
 * @Author：CreateSequence
 * @Date：2020-08-04 16:50
 * @Description：图
 */
public class Graph {

    //节点与节点间的相连关系
    private int[] node1;
    private int[] node2;
    //有几个节点
    private int num;
    //边的数量
    private int sideNum;

    //记录节点是否被访问
    private boolean[] isVisted;

    private int[][] graph;

    public Graph(int[] node1, int[] node2, int num) {
        this.node1 = node1;
        this.node2 = node2;
        this.num = num;
        this.sideNum = 0;

        //创建图
        CreateGraph();
    }

    /**
     * 创建图
     */
    private void CreateGraph(){
        //获取二维数组，一维表示节点，二维表示节点的相邻节点
        graph = new int[num][num];

        //初始化数组
        for (int i = 0; i < num; i++) {
            graph[i] = Arrays.copyOf(graph[i], num);
        }

        //添加节点
        for (int i = 0; i < node1.length; i++) {

            if (graph[node1[i]][node2[i]] == 0) {
                sideNum++;
            }

            graph[node1[i]][node2[i]] = 1;
            graph[node2[i]][node1[i]] = 1;
        }
    }

    /**
     * 展示图
     */
    public void show() {
        for (int[] n1 : graph) {
            for (int n2 : n1) {
                System.out.print(n2 + " ");
            }
            System.out.println();
        }

        System.out.println("有" + num + "个节点，" + sideNum + "条边");
    }

    /**
     * 查找邻接节点
     * @param index
     * @return
     */
    private int getNeighbor(int index) {
        for (int i = 0; i < graph.length; i++) {
            //如果当前节点存在邻接节点就返回下标
            if (graph[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找下一个邻接节点的下标
     * @param index1
     * @param index2
     * @return
     */
    private int getNextNeighbor(int index1, int index2) {
        for (int i = index2 + 1; i < graph.length; i++) {
            //如果当前节点存在邻接节点就返回下标
            if (graph[index1][index2] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先搜索
     * @param index
     */
    private void dsf(int index) {
        //访问节点
        System.out.print(index + "->");
        //标记已访问节点
        isVisted[index] = true;
        //获取第一个邻接节点
        int w = getNeighbor(index);
        //如果邻接节点存在
        while (w != -1){
            //并且该邻接节点未访问
            if (!isVisted[w]) {
                dsf(w);
            }
            //如果该节点已被访问,就访问当前节点的邻接节点的下一个邻接节点
            w = getNextNeighbor(index, w);
        }
    }

    public void dfs() {
        this.isVisted = new boolean[num];
        //对所有节点进行dfs
        for (int i = 0; i < num; i++) {
            //如果该节点仍未被访问才惊喜dfs
            if (!isVisted[i]) {
                dsf(i);
            }
        }
    }

    /**
     * 广度优先遍历
     * @param index
     */
    private void bfs(int index){
        //创建队列
        LinkedList queue = new LinkedList<>();

        //访问节点
        System.out.print(index + "->");
        //标记已访问节点
        isVisted[index] = true;
        //节点入队
        queue.addLast(index);

        //循环直到遍历完所有队列中的节点
        int u, w = -1;
        while (queue.isEmpty()) {
            //取出队列头结点下标
            u = (int) queue.removeFirst();
            //获取出队节点的邻接节点
            w = getNeighbor(u);
            while (w != -1) {
                //如果为被访问过
                if (!isVisted[w]) {
                    //访问节点并标记
                    System.out.print(u + "->");
                    isVisted[w] = true;
                    //将节点入队
                    queue.addLast(w);
                }

                //接着查找下一个邻接节点
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs() {
        this.isVisted = new boolean[num];
        //对所有节点进行bfs
        for (int i = 0; i < num; i++) {
            //如果该节点仍未被访问才惊喜dfs
            if (!isVisted[i]) {
                bfs(i);
            }
        }
    }

}
