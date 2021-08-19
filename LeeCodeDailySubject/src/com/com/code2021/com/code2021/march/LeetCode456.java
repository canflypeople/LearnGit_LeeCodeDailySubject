package com.com.code2021.com.code2021.march;

import java.util.Stack;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/3/24 上午9:05
 **/
public class LeetCode456 {
  // 栈
  public boolean find132pattern(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    int minRange = Integer.MAX_VALUE, maxRange = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
      if (stack.isEmpty()) {
        stack.push(num);
        minRange = Math.min(num, minRange);
      } else if (stack.size() == 1) {
        if (stack.peek() < num) {
          stack.push(num);
          maxRange = num;
        } else if (stack.peek() > num) {
          stack.pop();
          stack.push(num);
          minRange = Math.min(num, minRange);
        }
      } else if (stack.size() == 2) {
        int maxValue = stack.pop();
        int minValue = stack.peek();
        if (maxRange > num && minRange < num) {
          return true;
        } else if (num > maxValue) {
          stack.push(num);
          maxRange = Math.max(maxRange, num);
        } else if (num < minValue) {
          stack.pop();
          stack.push(num);
        }
      }
    }
    return false;
  }
}
