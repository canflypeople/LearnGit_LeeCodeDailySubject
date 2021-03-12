package com.com.code2021.com.code2021.march;

import java.util.Stack;

/**
 * @program:
 * @description:
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhongmou.ji
 * @create: 2021/3/11 下午1:36
 **/
public class LeeCode227 {

    public int calculate(String s) {
        // 栈
        // 如果当前是加减则入栈， 是乘则出栈和后一个数字做运算，再入栈
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        int currNum = 0;
        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '+' || c == '-') {
                ret += currNum;
                int[] arr = getNum(s, i + 1, c == '+' ? 1 : -1);
                i = arr[0];
                currNum = arr[1];
            } else if (c == '*') {
                int[] arr = getNum(s, i + 1, 1);
                currNum = currNum * arr[1];
                i = arr[0];
            } else if (c == '/') {
                int[] arr = getNum(s, i + 1, 1);
                currNum = currNum / arr[1];
                i = arr[0];
            } else {
                int[] arr = getNum(s, i, 1);
                currNum = arr[1];
                i = arr[0];
            }
        }
        return ret + currNum;
    }

    private int[] getNum(String s, int i, int flag) {
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i) - '0';
            i++;
        }
        return new int[]{i, flag * num};
    }

    public static void main(String[] args) {
        LeeCode227 leeCode227 = new LeeCode227();
        System.out.println(leeCode227.calculate(" 3+5 / 2 "));
    }
}
