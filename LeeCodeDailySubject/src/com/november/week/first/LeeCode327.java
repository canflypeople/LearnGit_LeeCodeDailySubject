package com.november.week.first;

public class LeeCode327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        // 暴力破解法
        // 求出每个符合条件的区间
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isInRange(getSum(nums, i, j), lower, upper)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isInRange(int sum, int lower, int upper) {
        return lower <= sum && sum <= upper;
    }

    public int getSum(int[] nums, int beginIndex, int endIndex) {
        int sum = 0;
        for (int i = beginIndex; i <= endIndex; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        LeeCode327 leeCode327 = new LeeCode327();
        leeCode327.countRangeSum(new int[] {-2147483647,0,-2147483647,2147483647}, -564, 3864);
    }
}
