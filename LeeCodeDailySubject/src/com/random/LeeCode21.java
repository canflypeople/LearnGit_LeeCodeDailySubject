package com.random;

public class LeeCode21 {

    public int removeElement(int[] nums, int val) {
        // 双指针
        int n = nums.length;
        int left = 0, right = 0;
        // offset = right - left
        int offset = 0;
        while (right < n) {
            while (right < n && nums[right] == val) {
                offset++;
                right++;
            }
            if (left + offset == n) {
                break;
            }
            if (offset > 0) {
                nums[left] = nums[left + offset];
            }
            left++;
            right++;
        }
        return offset;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        LeeCode21 leeCode21 = new LeeCode21();
        leeCode21.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }
}
