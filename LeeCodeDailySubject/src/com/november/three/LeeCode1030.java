package com.november.three;

import java.util.*;

public class LeeCode1030 {

    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[index++] = new int[]{i, j};
            }
        }
        Arrays.sort(ans, (o1, o2) -> Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0)));
        return ans;
    }

    /**
     * bfs
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        List<int[]> ans = new ArrayList<>();
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r0, c0});
        visited[r0][c0] = true;
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            ans.add(new int[]{x, y});
            for (int[] dir : dirs) {
                int tempX = x + dir[0];
                int tempY = y + dir[1];
                if (tempX >= 0 && tempX < R && tempY >= 0 && tempY < C && !visited[tempX][tempY]) {
                    queue.offer(new int[]{tempX, tempY});
                    visited[tempX][tempY] = true;
                }
            }
        }
        return ans.toArray(new int[R * C][2]);
    }

    /**
     * dfs
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        List<int[]> ans = new ArrayList<>();
        boolean[][] visited = new boolean[R][C];
        bfs(R, C, r0, c0, ans, visited);
        return ans.toArray(new int[R * C][2]);
    }

    private void bfs(int r, int c, int i, int j, List<int[]> ans, boolean[][] visited) {
        ans.add(new int[]{i, j});
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y]) {
                bfs(r, c, x, y, ans, visited);
            }
        }
    }

    public static void main(String[] args) {
        LeeCode1030 leeCode1030 = new LeeCode1030();
        leeCode1030.allCellsDistOrder2(2, 2, 0, 1);
    }


}
