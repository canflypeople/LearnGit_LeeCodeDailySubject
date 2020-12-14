package com.December;

import java.util.HashMap;

/**
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 */
public class LeeCode861 {

    /**
     * 贪心算法
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int count = getColumnCount(A, 0);
        return 1;

    }

    private void changeRow(int[][] A, int column) {

    }

    private int getColumnCount(int[][] A, int column) {
        int ans = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i][column] == 1) {
                ++ans;
            }
        }
        return ans;
    }

    private int getRowCount(int[][] A, int row) {
        int ans = 0;
        for (int i = 0; i < A[row].length; ++i) {
            if (A[row][i] == 1) {
                ++ans;
            }
        }
        return ans;
    }
}
