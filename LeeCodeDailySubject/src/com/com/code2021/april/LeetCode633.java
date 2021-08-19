package com.com.code2021.april;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/4/28 上午9:32
 **/
public class LeetCode633 {

  public boolean judgeSquareSum(int c) {
    long left = 0, right = (long) Math.sqrt(c);
    while (left < right) {
      long sum = left * left + right * right;
      if (sum > c) {
        right--;
      } else if (sum < c){
        left++;
      } else if (sum == c) {
        return true;
      }
    }
    return false;
  }
}
