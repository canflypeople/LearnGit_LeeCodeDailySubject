package com.com.code2021.com.code2021.march;

/**
 * @program:
 * @description:
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * @author: zhongmou.ji
 * @create: 2021/3/2 上午9:29
 **/
public class LeeCode304 {
    class NumMatrix {
        // 前缀和
        int[][] preSums;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                preSums = matrix;
                return;
            }
            int m = matrix.length, n = matrix[0].length;
            preSums = new int[m][n];
            for (int i = 0 ; i < m; i++) {
                preSums[i][0] = matrix[i][0];
                for (int j = 1; j < n; j++) {
                    preSums[i][j] = preSums[i][j - 1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (preSums == null) {
                return 0;
            }
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += preSums[i][col2] - (col1 == 0 ? 0 : preSums[i][col1 - 1]);
            }
            return sum;
        }
    }
}
