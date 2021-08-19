package com.com.code2021.june;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/6/7 上午10:34
 **/
public class LeetCode494 {
  int count = 0;
  public int findTargetSumWays(int[] nums, int target) {
    backtract(nums, target, 0, 0);
    return count;
  }

  private void backtract(int[] nums, int target, int index, int sum) {
    if (index == nums.length) {
      if (sum == target) {
        count++;
      }
    } else {
      backtract(nums, target, index + 1, sum + nums[index]);
      backtract(nums, target, index + 1, sum - nums[index]);
    }

  }


  public static void main(String[] args) {
    A a = new B();
    System.out.println(a.getClass().getName());
  }


}

class A {

}

class B extends A {

}
