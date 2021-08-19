package com.com.code2021.may;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/6 上午9:18
 **/
public class LeetCode1720 {

  public int[] decode(int[] encoded, int first) {
    int encodedSize = encoded.length;
    int originSize = encodedSize + 1;
    int[] res = new int[originSize];
    res[0] = first;
    for (int i = 0; i < encodedSize; i++) {
      res[i + 1] = encoded[i] - res[i];
    }
    return res;

  }
}
