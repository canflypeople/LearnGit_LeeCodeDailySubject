package com.com.code2021.june;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/6/27 上午10:35
 **/
public class MatchFour {

  public static int[][] rotateGrid(int[][] grid, int k) {
    int m = grid.length, n = grid[0].length;
    // 层数
    int storeyCount = (Math.min(m, n) - 1) / 2 + 1;
    int[][] res = new int[m][n];
    System.arraycopy(grid, 0, res, 0, m);
    List<Integer>[] storeyList = new ArrayList[storeyCount];
    for (int i = 0; i < storeyCount; i++) {
      List<Integer> storeyNums = new ArrayList<>();
      int lowRow = i, highRow = m - i - 1;
      int leftCol = i, rightCol = n - i - 1;
      for (int col = leftCol; col <= rightCol; col++) {
        storeyNums.add(grid[lowRow][col]);
      }
      for (int row = lowRow + 1; row <= highRow; row++) {
        storeyNums.add(grid[row][rightCol]);
      }
      for (int col = rightCol - 1; col >= leftCol; col--) {
        storeyNums.add(grid[highRow][col]);
      }
      for (int row = highRow - 1; row >= Math.max(lowRow - 1, 0); row--) {
        storeyNums.add(grid[row][leftCol]);
      }
      int len = storeyNums.size();
      int revolveCount = k % len;
      Integer[] revolveArr = new Integer[len];
      Integer[] originArr = new Integer[len];
      storeyNums.toArray(originArr);
      System.arraycopy(originArr, revolveCount, revolveArr, 0, len - revolveCount);
      System.arraycopy(originArr, 0, revolveArr, len - revolveCount, revolveCount);
      int index = 0;
      for (int col = leftCol; col <= rightCol; col++) {
        grid[lowRow][col] = revolveArr[index];
        index++;
      }
      for (int row = lowRow + 1; row <= highRow; row++) {
        grid[row][rightCol] = revolveArr[index];
        index++;
      }
      for (int col = rightCol - 1; col >= leftCol; col--) {
        grid[highRow][col] = revolveArr[index];
        index++;
      }
      for (int row = highRow - 1; row >= Math.max(0, lowRow - 1); row--) {
        grid[row][leftCol] = revolveArr[index];
        index++;
      }
    }
    return grid;


//    int[] storeyLens = new int[storey];
//    int currStoreyLen = (m + n) * 2 - 4;
//    for (int i = storey - 1; i > 0; i--) {
//      storeyLens[i] = currStoreyLen;
//      currStoreyLen -= 4;
//    }
//    // 最中间一层做特殊处理
//    storeyLens[0] = ((currStoreyLen + 4) - 6) / 2;
//    List<Integer>[] storeyList = new ArrayList[storey];
//    int index = 0;
//    while (index < storey) {
//      List<Integer> nums = new ArrayList<>();
//      // i j
//      int row, col;
//      if (m % 2 == 0) {
//        row = m / 2;
//      } else {
//
//      }
//
//
//      index--;
//    }
  }

  public static void main(String[] args) {
    rotateGrid(new int[][]{new int[]{40, 10}, new int[]{30, 20}}, 1);
  }
}
