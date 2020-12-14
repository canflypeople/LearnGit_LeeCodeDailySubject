package com.random;

import java.util.HashMap;
import java.util.Map;

public class LeeCode697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxCount = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int[] arr = map.getOrDefault(nums[i], new int[]{i, i, 0});
            arr[1] = i;
            ++arr[2];
            map.put(nums[i], arr);
        }
        for (int[] arr : map.values()) {
            if (arr[2] == maxCount) {
                minLength = Math.min(minLength, arr[1] - arr[0] + 1);
            } else if (arr[2] > maxCount) {
                maxCount = arr[2];
                minLength = arr[1] - arr[0] + 1;
            }
        }

        return maxCount;

    }

    public static void main(String[] args) {
        LeeCode697 leeCode697 = new LeeCode697();
        leeCode697.findShortestSubArray(new int[]{1,2,2,3,1,4,2});
    }
}
