package com.november.four;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeeCode454 {

    /**
     * 哈希表，
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sum1 = new HashMap<>();
        Map<Integer, Integer> sum2 = new HashMap<>();
        int cnt = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum1.put(A[i] + B[j], sum1.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum2.put(C[i] + D[j], sum2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : sum1.entrySet()) {
            int sum = entry.getKey();
            int count = entry.getValue();
            if (sum2.containsKey(-sum)) {
                cnt += count * sum2.get(-sum);
            }
        }
        return cnt;
    }

    /**
     * 不需要使用两个哈希表来存储，得到第一组数据的和，后续直接在遍历第二组的值和第一组的值来比较即可
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        LeeCode454 leeCode454 = new LeeCode454();
        leeCode454.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1, 2}, new int[]{0, 2});
    }
}
