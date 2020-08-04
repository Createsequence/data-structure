package com.huang.example.tree.graph;

import com.huang.example.graph.Graph;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author：CreateSequence
 * @Date：2020-08-04 17:02
 * @Description：<描述>
 */
public class GraphTest {

    static Graph graph;

    @BeforeClass
    public static void testCreate() {

        //int num = 5;
        //int[] u = {0, 0, 0, 0, 1};
        //int[] v = {1, 2, 3, 4, 2};
        int num = 9;
        int[] u = {0, 0, 1, 2, 3, 3, 4, 4};
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8};

        graph = new Graph(u, v, num);
        graph.show();
    }

    @Test
    public void testDFS() {
        graph.dfs();
    }

    @Test
    public void testBFS() {
        graph.bfs();
    }
}
