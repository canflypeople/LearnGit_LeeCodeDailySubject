package com.com.code2021.may;

/**
 * @program:
 * @description:
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhongmou.ji
 * @create: 2021/5/12 上午9:32
 **/
public class LeetCode1310 {

  /**
   *
   * @param arr
   * @param queries
   * @return
   */
  public int[] xorQueries(int[] arr, int[][] queries) {
    int n = arr.length;
    int[] rox = new int[n + 1];
    for (int i = 0; i < n; i++) {
      rox[i + 1] = rox[i] ^ arr[i];
    }
    int m = queries.length;
    int[] ans = new int[m];
    for (int i = 0; i < m; i++) {
      ans[i] = rox[queries[i][0]] ^ rox[queries[i][1] + 1];
    }
    return ans;

  }
}
