package com.code2020.January;

/**
 * @program:
 * @description:
 * 1579. 保证图可完全遍历
 * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 *
 * 类型 1：只能由 Alice 遍历。
 * 类型 2：只能由 Bob 遍历。
 * 类型 3：Alice 和 Bob 都可以遍历。
 * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 *
 * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
 * @author: zhongmou.ji
 * @create: 2021/1/27 上午9:17
 **/
public class LeeCode159 {

    /**
     * 并查集
     * @param n
     * @param edges
     * @return
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);
        for (int[] edge : edges) {
            --edge[1];
            --edge[2];
        }
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!ufa.union(edge[1], edge[2])) {
                    ans++;
                } else {
                    ufb.union(edge[1], edge[2]);
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!ufa.union(edge[1], edge[2])) {
                    ans++;
                }
            } else if (edge[0] == 2) {
                if (!ufb.union(edge[1], edge[2])) {
                    ans++;
                }
            }
        }
        if (ufa.getCount() != 1 || ufb.getCount() != 1) {
            return -1;
        }
        return ans;

    }

    class UnionFind {
        int[] parent;
        int n;
        int count;

        public UnionFind(int n) {
            this.n = n;
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int index1, int index2) {
            int root1 = find(index1);
            int root2 = find(index2);
            if (root1 == root2) {
                return false;
            }
            parent[root1] = root2;
            count--;
            return true;
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }

        public int getCount() {
            return count;
        }


    }


}
