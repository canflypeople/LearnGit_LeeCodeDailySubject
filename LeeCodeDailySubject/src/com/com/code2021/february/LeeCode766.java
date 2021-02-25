package com.com.code2021.february;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/22 上午9:05
 **/
public class LeeCode766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return true;
        }
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < n - 1; i++) {
            if (check(matrix, 0, i)) {
                return false;
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (check(matrix, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int i, int j) {
        int value = matrix[i][j];
        i++;
        j++;
        while (i< matrix.length && j < matrix[0].length) {
            if (matrix[i][j] != value) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
