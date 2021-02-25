package com.code2020.January;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class LeeCode189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newNums = new int[n];
        for (int i = 0; i < n; i++) {
            newNums[(i + k) % n] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        LeeCode189 leeCode189 = new LeeCode189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        leeCode189.rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
