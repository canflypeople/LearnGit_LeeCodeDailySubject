package com.november.four;

import java.util.Arrays;

/**
 * 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 */
public class LeeCode493 {

    /**
     * 暴力破解
     */
    public int reversePairs(int[] nums) {
        int length = nums.length;
        int ans = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] - nums[j] > nums[j] ) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 归并排序
     * 算法步骤：
     * 1。 对数组进行归并排序
     * 2。 两部分内所有的翻转对个数 等于 两个部分各自的个数之和加上
     * 一个点在左边部分，一个点在右边部分的符合条件个数之和，这部分直接使用双指针来实现
     * @param nums
     * @return
     */
    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        return mergePairs(nums, 0, nums.length - 1);
    }

    /**
     * 步骤：
     * 1。 将p~q分为两部分，对这两部分进行归并排序
     * 2。 汇总这两部分的个数，并求初一个点在左边，一个点在右边符合条件的个数
     * 3。 对两部分进行排序返回
     * @param nums
     * @param p
     * @param q
     * @return
     */
    private int mergePairs(int[] nums, int p, int q) {
        if (p >= q) {
            return 0;
        }
        int mid = (q - p) / 2 + p; // 防止长度溢出
        int leftCount = mergePairs(nums, p, mid);
        int rightCount = mergePairs(nums, mid + 1, q);
        int ans = leftCount + rightCount;
        // 求出一个点在左边，一个在右边符合条件的个数
        int left = p, right = mid + 1;
        while (left <= mid) {
            while (right <= q && (long)nums[left] > 2 * (long)nums[right]) {
                right++;
            }
            ans += right - (mid + 1);
            left++;
        }
        // 对两个部分进行排序
        if (p == 0 && q == nums.length - 1) {
            return ans;
        }
        int[] leftNums = Arrays.copyOfRange(nums, p, mid + 1);
        int[] rightNums = Arrays.copyOfRange(nums, mid + 1, q + 1);
        int i = 0, j = 0, index = p;
        while (i < leftNums.length && j < rightNums.length) {
            if (leftNums[i] > rightNums[j]) {
                nums[index] = rightNums[j];
                j++;
            } else {
                nums[index] = leftNums[i];
                i++;
            }
            index++;
        }
        while (i < leftNums.length) {
            nums[index] = leftNums[i];
            i++;
            index++;
        }
        while (j < rightNums.length) {
            nums[index] = rightNums[j];
            j++;
            index++;

        }
        return ans;
    }

    public static void main(String[] args) {
        LeeCode493 leeCode493 = new LeeCode493();
        leeCode493.reversePairs1(new int[]{1,3,2,3,1});
    }
}
