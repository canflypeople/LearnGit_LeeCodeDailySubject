package com.com.code2021.com.code2021.march;

/**
 * @program:
 * @description:
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 * @author: zhongmou.ji
 * @create: 2021/3/16 上午9:03
 **/
public class LeeCode59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] ans = new int[n][n];
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            if (left <= right && top <= bottom) {
                 for (int i = right - 1; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
                for (int i = bottom - 1; i > top; i--) {
                    ans[i][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeeCode59 leeCode59 = new LeeCode59();
        for (int[] arr : leeCode59.generateMatrix(3)) {
            for (int num : arr) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
