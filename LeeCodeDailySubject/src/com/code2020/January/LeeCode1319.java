package com.code2020.January;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/1/23 下午10:45
 *
 * 1319. 连通网络的操作次数
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 **/
public class LeeCode1319 {

    /**
     * 并查集
     */
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int restLine = 0;
        for (int[] connection : connections) {
            restLine += uf.connect(connection[0], connection[1]);
        }
        if (uf.getCount() == 1) {
            return 0;
        }
        return uf.getCount() - 1 <= restLine ? uf.getCount() - 1 : -1;
    }

    class UnionFind {
        private int[] parent; // 存储父节点
        private int n; // 长度
        private int count; // 连通分量

        public UnionFind(int n) {
            parent = new int[n];
            this.n = n;
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int getCount() {
            return count;
        }

        public int connect(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return 1;
            }
            parent[rootP] = rootQ;
            count--;
            return 0;
        }

        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }
    }

}
