package com.com.code2021.april;

import java.util.Arrays;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/4/30 上午9:26
 **/
public class LeetCode137 {

  public int singleNumber(int[] nums) {
    // 排序，获取长度
    Arrays.sort(nums);
    int n = nums.length;
    // 二分查找， 数是在左边还是右边， 调整
    int left = 0, right = n - 1;
    while (left <= right) {
      if (left == right) {
        return nums[left];
      }
      int mid = (right - left) /2 + left;
      int leftBorder = mid - 1;
      while (leftBorder >= 0 && nums[leftBorder + 1] == nums[leftBorder]) {
        leftBorder--;
      }
      int rightBorder = mid + 1;
      while (right < n && nums[rightBorder - 1] == nums[rightBorder]) {
        rightBorder++;
      }
      int leftSize = leftBorder - left + 1;
      int rightSize = right - rightBorder + 1;
      if (leftSize % 3 != 0) {
        right = leftBorder;
      } else if (rightSize % 3 != 0) {
        left = rightBorder;
      } else {
        return nums[mid];
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    LeetCode137 leetCode137 = new LeetCode137();
    System.out.println(leetCode137.singleNumber(new int[]{2,2,3,2}));
  }
}
