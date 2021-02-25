package com.code2020.January;

import com.util.DisjoinSetUnion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 */
public class LeeCode547 {

    /**
     * 并查集
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        DisjoinSetUnion dsu = new DisjoinSetUnion(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isConnected[i][j] == 1) {
                    dsu.unionSet(i, j);
                }
            }
        }
        return dsu.getCount();
    }

    /**
     * 图+广度优先遍历
     * @param isConnected
     * @return
     */
    public int findCircleNum1(int[][] isConnected) {
        int count = 0;
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(visited, i, provinces, isConnected);
                circles++;
            }
        }
        return circles;
    }

    private void dfs(boolean[] visited, int i, int provinces, int[][] isConnected) {
        for (int j = 0; i < provinces; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(visited, j, provinces, isConnected);
            }
        }
    }
}
