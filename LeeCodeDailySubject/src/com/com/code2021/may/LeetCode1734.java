package com.com.code2021.may;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/11 上午9:31
 **/
public class LeetCode1734 {

  public int[] decode(int[] encoded) {
    int n = encoded.length + 1;
    int total = 0;
    for (int i = 1; i <= n; i++) {
      total ^= i;
    }
    int odd = 0;
    for (int i = 1; i < n - 1; i += 2) {
      odd ^= encoded[i];
    }
    int[] perm = new int[n];
    perm[0] = total ^ odd;
    for (int i = 0; i < n - 1; i++) {
      perm[i + 1] = perm[i] ^ encoded[i];
    }
    return perm;

  }
}
