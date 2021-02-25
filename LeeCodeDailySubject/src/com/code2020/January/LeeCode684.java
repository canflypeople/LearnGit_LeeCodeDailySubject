package com.code2020.January;

import java.util.Arrays;

/**
 *684. 冗余连接
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 *
 * 示例 1：
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 */
public class LeeCode684 {

    /**
     * 并查集：找到连接的边，两个节点的根节点是同一个，则表示有环
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int nodeCount = edges.length;
        int[] parent = new int[nodeCount + 1];
        for (int i = 1; i < nodeCount; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[2];
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);

    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }

    public static void main(String[] args) {
        LeeCode684 leeCode684 = new LeeCode684();
        leeCode684.findRedundantConnection(new int[][]{new int[]{1,2}, new int[]{1,3}, new int[]{2,3}});
    }

    /*public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        // 新建每个节点的根节点
        int[] parent = new int[nodesCount + 1];
        // 初始化每个节点的根节点都为1
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = 1;
        }
        // 遍历边，查找环
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            // 查找节点对应的父节点是否一致，不一致则合并
            if (find(parent, node1) != find(parent, node2)) {
                // 连接
                union(parent, node1, node2);
            } else {
                // 一致则说明有环，返回当前边
                return edge;
            }
        }
        return new int[0];
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }*/


}
