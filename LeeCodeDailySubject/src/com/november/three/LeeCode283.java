package com.november.three;

import java.util.Arrays;

public class LeeCode283 {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int left = 0, right = 0;
        while (right < length) {
            while (nums[right] == 0) {
                right++;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            left++;
            right++;
        }
        Arrays.fill(nums, left, length, 0);
    }

    public static void main(String[] args) {
        LeeCode283 leeCode283 = new LeeCode283();
        leeCode283.moveZeroes(new int[]{0,1,0,3,12});
    }
}
