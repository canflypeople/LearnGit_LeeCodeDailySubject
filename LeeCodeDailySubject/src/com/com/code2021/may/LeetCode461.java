package com.com.code2021.may;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/27 上午9:33
 **/
public class LeetCode461 {

  public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    // 统计 1 的个数
    return Integer.bitCount(xor);
  }
}
