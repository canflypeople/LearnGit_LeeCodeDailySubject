package com.com.code2021.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/26 下午11:11
 **/
public class LeetCode1190 {


  /**
   * 给出一个字符串 s（仅含有小写英文字母和括号）。
   *
   * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
   *
   * 注意，您的结果中 不应 包含任何括号。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：s = "(abcd)"
   * 输出："dcba"
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * @param s
   * @return
   */
  public String reverseParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    Stack<Integer> lenStack = new Stack<>();
    int n = s.length();
    int index = 0;
    while (index < n) {
      char c = s.charAt(index);
      if (c == '(') {
        int len = 0;
        while (index + 1 < n && s.charAt(index + 1) != '(' && s.charAt(index + 1) != ')') {
          stack.push(s.charAt(index + 1));
          index++;
          len++;
        }
        lenStack.push(len);
        index++;
      } else if (c == ')') {
        List<Character> list = new ArrayList<>();
        int len = lenStack.pop();
        if (!lenStack.isEmpty()) {
          lenStack.push(lenStack.pop() + len);
        }
        while (len > 0) {
          list.add(stack.pop());
          len--;
        }
        for (Character character : list) {
          stack.push(character);
        }
        index++;
      } else {
        while (index < n && s.charAt(index) != '(' && s.charAt(index) != ')') {
          lenStack.push(lenStack.pop() + 1);
          stack.push(c);
          index++;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();



  }

  public static void main(String[] args) {
    LeetCode1190 leetCode1190 = new LeetCode1190();
    leetCode1190.reverseParentheses("(u(love)i)");
  }
}
