package com.com.code2021.february;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/25 上午9:02
 **/
public class LeeCode867 {

    public int[][] transpose(int[][] matrix) {
        if(matrix.length == 0) {
            return matrix;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            while (left < right) {
                int temp = res[i][left];
                res[i][left] = res[i][right];
                res[i][right] = temp;
                left++;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeeCode867 leeCode867 = new LeeCode867();
        leeCode867.transpose(new int[][]{new int[]{1,2,3},new int[]{4,5,6}});
    }
}
