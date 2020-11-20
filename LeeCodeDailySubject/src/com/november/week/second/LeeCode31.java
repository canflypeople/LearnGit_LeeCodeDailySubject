package com.november.week.second;

import java.util.Arrays;

public class LeeCode31 {

    public void nextPermutation(int[] nums) {
        // 先判断数组是否是升序的，
        int pre = nums[0];
        boolean isDesc = true;
        for (int i = 1; i < nums.length; i++) {
            if (pre < nums[i]) {
                isDesc = false;
                break;
            }
        }

    }
}
