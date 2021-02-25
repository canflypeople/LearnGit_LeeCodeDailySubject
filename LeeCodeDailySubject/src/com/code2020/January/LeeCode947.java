package com.code2020.January;

import java.util.*;

/**
 * 947. 移除最多的同行或同列石头
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 *
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 */
public class LeeCode947 {

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();

    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
            count--;

        }
    }

    /**
     * 并查集--图月
     * 手动连接
     * @param stones
     * @return
     */
    public int removeStones2(int[][] stones) {
        int n = stones.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }
        return n - uf.getCount();

    }

    class UF {
        int[] parent; // 每个节点对应的
        int[] size; // 每个节点的子节点个数
        int count; // 连通分量
        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        public int getCount() {
            return count;
        }

        public boolean connected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 == root2) {
                return;
            }
            if (size[root1] > size[root2]) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
            }
            count--;
        }
    }

    public int removeStones1(int[][] stones) {
        int ans = 0;
        if (stones.length == 0) {
            return ans;
        }
        Arrays.sort(stones, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int m = stones[stones.length - 1][0], n = 0;
        List<PriorityQueue<int[]>> stonesRows = new ArrayList<>();
        int index = 0;
        for (int[] stone : stones) {
            n = Math.max(n, stone[1]);
        }
        int row[] = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> o1[1] > o2[1] ? 1 : -1);
            while (index < stones.length && stonesRows.size() == stones[index][0]) {
                queue.offer(new int[]{stones[index][1], row[stones[index][1]]});
                row[stones[index][1]]++;
                index++;
            }
            stonesRows.add(queue);
        }
        for (int i = stonesRows.size() - 1; i >= 0; i--) {
            PriorityQueue<int[]> queue = stonesRows.get(i);
            while (queue.size() >= 2 || (!queue.isEmpty() && queue.peek()[1] >= 1)) {
                queue.poll();
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeeCode947 leeCode947 = new LeeCode947();
        leeCode947.removeStones(new int[][]{new int[]{0,0}, new int[]{0,1}, new int[]{1,0}, new int[]{1,2}, new int[]{2,1}, new int[]{2,2}});
    }
}
