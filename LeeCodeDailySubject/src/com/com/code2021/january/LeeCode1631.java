package com.com.code2021.january;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description:
 * 1631. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 *
 *
 *
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * @author: zhongmou.ji
 * @create: 2021/1/30 下午1:59
 **/
public class LeeCode1631 {
    /**
     * 并查集：根据边的权重排序，然后进行排序 合并
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        // 算出每条边的权重，
        List<int[]> edges = new ArrayList<>();
        int m = heights[0].length;
        int n = heights.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * m + j;
                // 不用管其顺序，最后要进行排序
                if (i > 0) {
                    edges.add(new int[]{id - m, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j - 1] - heights[i][j])});
                }
            }
        }
        // 对边根据权重进行排序
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] >= o2[2] ? 1 : -1;
            }
        });
        // 初始化并查集
        UnionFind uf = new UnionFind(m * n);
        // 连接
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.union(x, y);
            if (uf.isConnected(0, m * n - 1)) {
                return v;
            }
        }
        return ans;
    }

    class UnionFind {
        private int[] parents;
        private int count;
        private int n;

        public UnionFind(int n) {
            this.n = n;
            count = n;
            parents = new int[n];
            for (int i = 0; i < n; i++){
                parents[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parents[rootP] = rootQ;
            count--;
        }

        private int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return parents[x];
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public static void main(String[] args) {
        LeeCode1631 leeCode1631 = new LeeCode1631();
        leeCode1631.minimumEffortPath(new int[][]{{1,10,6,7,9,10,4,9}});
        leeCode1631.minimumEffortPath(new int[][]{{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}});
    }

}
