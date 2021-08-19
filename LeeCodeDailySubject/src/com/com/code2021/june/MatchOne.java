package com.com.code2021.june;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/6/6 上午11:04
 **/
public class MatchOne {

  /**
   *
   * @param mat
   * @param target
   * @return
   */
  public boolean findRotation(int[][] mat, int[][] target) {
    for (int i = 1; i <= 4; i++) {
      mat = revolveRotation(mat);
      if (isSameArray(mat, target)) {
        return true;
      }
    }
    return true;
  }

  public boolean isSameArray(int[][] arr1, int[][] arr2) {
    int m1 = arr1.length, n1 = arr1[0].length;
    int m2 = arr2.length, n2 = arr2[0].length;
    if (m1 != m2 || n1 != n2) {
      return false;
    }
    for (int i = 0; i < m1; i++) {
      for (int j = 0; j < n1; j++) {
        if (arr1[i][j] != arr2[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * 顺时针旋转90度
   * @param arr
   * @return
   */
  public int[][] revolveRotation(int[][] arr) {
    int m = arr.length, n = arr[0].length;
    int[][] res = new int[n][m];
    for (int i = 0; i < m; i++) {
      // res 对应的列都是 n - i;
      for (int j = 0; j < n; j++) {
        res[j][n - 1 - i] = arr[i][j];
      }
    }
    return res;
  }

  public int minFlips(String s) {
    // 查看长度是奇数还是偶数
    return 0;
    // 偶数的话，0在前1在前都可以

    // 奇数的话， 必须有一个是在前的

    // 统计 1在前，有多少是在正确的位置的， 0在前， 有多少是在正确的位置的

  }

  public static void main(String[] args) {

  }
}
