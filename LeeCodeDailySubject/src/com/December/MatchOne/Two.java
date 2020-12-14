package com.December.MatchOne;

import java.util.Arrays;

/**
 * 5618. K 和数对的最大数目
 * 题目难度Medium
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数
 */
public class Two {

    /**
     * 双指针
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                ans += 2;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else if (sum > k) {
                break;
            }
        }
        return ans;

    }
}
