package com.com.code2021.february;

/**
 * @program:
 * @description:
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * @author: zhongmou.ji
 * @create: 2021/2/24 上午8:59
 **/
public class LeeCode832 {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0) {
            return A;
        }
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int temp = A[i][left];
                A[i][left] = A[i][right] == 1 ? 0 : 1;
                A[i][right] = temp == 1 ? 0 : 1;
                left++;
                right--;
            }
        }
        return A;
    }
}
