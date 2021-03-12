package com.com.code2021.com.code2021.march;

import java.util.Stack;

/**
 * @program:
 * @description:
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * @author: zhongmou.ji
 * @create: 2021/3/10 下午6:19
 **/
public class LeeCode224 {
    public int calculate(String s) {
        int ret = 0;
        // 栈 后进先出
        // 栈中存储的是符号， 相当于每个数字都有其对应的符号，简化
        // 当前的符合等于 栈中的符号 * 当前的符号
        Stack<Integer> ops = new Stack<>();
        ops.push(1);
        int sign = 1;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                ret += num;
            }
        }
        return ret;
    }

}
