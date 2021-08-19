package com.com.code2021.com.code2021.march;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * @author: zhongmou.ji
 * @create: 2021/3/15 上午9:07
 **/
public class LeetCode54 {

    private int top, bottom, left, right;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int m = matrix.length, n = matrix[0].length;
        top = 0;
        bottom = m - 1;
        left = 0;
        right = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top; i--) {
                    ans.add(matrix[left][bottom]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;

    }
}
