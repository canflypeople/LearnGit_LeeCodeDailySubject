package com.com.code2021.may;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/31 上午9:34
 **/
public class LeetCode342 {

  public boolean isPowerOfFour(int n) {
    while (n > 0) {
      if (n % 4 != 0) {
        return false;
      }
      n /= 4;
    }
    return true;
  }

  public static void main(String[] args) {
    LeetCode342 leetCode342 = new LeetCode342();
    leetCode342.isPowerOfFour(16);
  }
}
