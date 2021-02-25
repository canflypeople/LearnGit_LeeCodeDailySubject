package com.com.code2021.january;

/**
 * @program:
 * @description:
 * 778. 水位上升的泳池中游泳
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 *
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 *
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[0,2],[1,3]]
 * 输出: 3
 * 解释:
 * 时间为0时，你位于坐标方格的位置为 (0, 0)。
 * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
 *
 * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 * @author: zhongmou.ji
 * @create: 2021/1/30 下午1:30
 **/
public class LeeCode778 {

    private int N;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 并查集
     * @param grid
     * @return
     */
    public int swimInWater(int[][] grid) {
        // 设置每个水位对应的坐标位置，i * N + j
        this.N = grid.length;
        int len = N * N;
        int[] index = new int[len];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                index[grid[i][j]] = getIndex(i, j);
            }
        }
        // 初始化并查集
        UnionFind uf = new UnionFind(len);
        // 从0-N*N-1 遍历，直到 0和len - 1可以连接则停止
        for (int i = 0; i < len; i++) {
            int x = index[i] / N;
            int y = index[i] / N;
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && grid[newX][newY] <= i) {
                    uf.union(index[i], getIndex(newX, newY));
                }
                if (uf.isConnected(0, len - 1)) {
                    return i;
                }
            }
        }
        return -1;

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private int getIndex(int i, int j) {
        return i * N + j;
    }

    static class UnionFind {
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
}
