package com.December.match.three;

import java.util.*;

public class Solution {

    public String reformatNumber(String number) {
        String str = number.replaceAll("-", "").replaceAll(" ", "");
        int n = str.length();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < n) {
            if (n - index > 4) {
                sb.append(str.substring(index, index + 3) + "-");
                index += 3;
            } else {
                if (n - index == 4) {
                    sb.append(str.substring(index, index + 2) + "-" );
                    sb.append(str.substring(index + 2, index + 4));
                } else {
                    sb.append(str.substring(index, n));
                }
                break;
            }
        }
        return sb.toString();

    }

    /**
     * 本质上就是求连续子数组的元素和最大值，且连续子数组不能有相同的元素
     * 滑动窗口
     * 前缀和
     * @param nums
     * @return
     */
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, List<Integer>> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = count.getOrDefault(nums[i], new ArrayList<Integer>());
            list.add(i);
            count.put(nums[i], list);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 1;
        int n = nums.length;
        int[] preSum = getPreSum(nums);
        map.put(nums[0], 0);
        int maxSum = nums[0];
        while (right < n) {
            if (map.containsKey(nums[right])) {
                int preRight = map.get(nums[right]);
                for (int i = left; i <= preRight; i++) {
                    map.remove(nums[i]);
                }
                left = preRight + 1;
            } else {
                if (maxSum < preSum[right] - (left - 1 < 0 ? 0 : preSum[left - 1])) {
                    System.out.println(left + "----" + right);
                }
                maxSum = Math.max(maxSum, preSum[right] - (left - 1 < 0 ? 0 : preSum[left - 1]));
            }
            map.put(nums[right], right);
            right++;
        }
        int length = nums.length;
        return maxSum;

    }

    private int[] getPreSum(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] +  nums[i];
        }
        return preSum;
    }

    /**
     * 动态规划
     * @param nums
     * @param k
     * @return
     */
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        // 初始化
        for (int i = 1; i < n; i++) {
            int result = Integer.MIN_VALUE;
            for (int temp = (i - k >= 0 ? i - k : 0); temp <= i; temp++) {
                result = Math.max(result, dp[temp]);
            }
            dp[i] = result + nums[i];
        }
        return dp[n - 1];


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximumUniqueSubarray(new int[]{4,2,4,5,6});
        solution.reformatNumber("1-23-45 6");
    }
}
