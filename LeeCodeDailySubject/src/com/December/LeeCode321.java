package com.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2020/12/02
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 */
public class LeeCode321 {

    /**
     * 单调栈
     * 算法：
     * 1。 获取两个数组中的最长子序列
     * 2。 获取最长子序列组合的最大值，使用单调栈
     * 3。 整合结果
     * 类似分治法
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubsequence = new int[k];
        int start = Math.max(0, k - n), end = Math.min(m, k);
        for (int i = start; i <= end; i++) {
            int[] subSequence1 = maxSubsequence(nums1, i);
            int[] subSequence2 = maxSubsequence(nums2, k - i);
            int[] currSubsequence = merge(subSequence1, subSequence2);
            if (compare(currSubsequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(currSubsequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;
    }

    /**
     * 单调栈，用数组维护
     * 获取数组中的最大子序列
     * @param nums
     * @param k
     * @return
     */
    private int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num =nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    /**
     * 合并两个数组，获取一个最大序列
     * @param subsequence1
     * @param subsequence2
     * @return
     */
    private int[] merge(int[] subsequence1, int[] subsequence2) {
        if (subsequence1.length == 0) {
            return subsequence2;
        }
        if (subsequence2.length == 0) {
            return subsequence1;
        }
        int x = subsequence1.length, y = subsequence2.length;
        int[] merged = new int[x + y];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < merged.length; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    /**
     * 比较两个数组的大小
     * @param subsequence1
     * @param index1
     * @param subsequence2
     * @param index2
     * @return
     */
    private int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }





    public static void main(String[] args) {
        LeeCode321 leeCode321 = new LeeCode321();
        leeCode321.maxNumber(new int[]{6,7},
                    new int[]{6,0,4}, 5);
    }
}
