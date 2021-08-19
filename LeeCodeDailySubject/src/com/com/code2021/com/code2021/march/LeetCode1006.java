package com.com.code2021.com.code2021.march;

import java.util.Stack;

/**
 * @program:
 * @description:
 * 1006. 笨阶乘
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 *
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 *
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 *
 *
 * 示例 1：
 *
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 * @author: zhongmou.ji
 * @create: 2021/4/1 上午9:08
 **/
public class LeetCode1006 {

  /**
   * 重要的参数， 之前数的和， 当前是第几个轮回， 当前是第一个数字还是第二个数字， 剩余数字
   * @param N
   * @return
   */
  public int clumsy(int n) {
    Stack<Integer> stack = new Stack<>();
    stack.push(n--);
    int index = 0;
    while (n > 0) {
      if (index % 4 == 0) {
        stack.push(stack.pop() * n);
      } else if (index % 4 == 1) {
        stack.push(stack.pop() / n);
      } else if (index % 4 == 2) {
        stack.push(n);
      } else {
        stack.push(-n);
      }
      n--;
    }
    int res = 0;
    while (!stack.isEmpty()) {
      res += stack.pop();
    }
    return res;

  }

}
