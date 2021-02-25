package com.com.code2021.january;

/**
 * @program:
 * @description:
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * @author: zhongmou.ji
 * @create: 2021/2/4 上午9:23
 **/
public class LeeCode643 {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        for (int i = k; i < n; i++) {
            if (nums[i] > nums[i - k]) {
                sum += nums[i] - nums[i - k];
            }
        }
        return  sum * 1.0 / k;

    }
}
