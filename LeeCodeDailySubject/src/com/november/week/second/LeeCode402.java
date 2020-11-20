package com.november.week.second;

import java.util.Stack;

public class LeeCode402 {

    public String removeKdigits(String num, int k) {
        // 寻找S[i] > S[i + 1] 去掉S[i]
        // 维护一个栈，重复利用
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < num.length()) {
            int currNum = num.charAt(index++) - '0';
            while (k > 0 && (stack.isEmpty() ? Integer.MIN_VALUE : stack.peek()) > currNum) {
                stack.pop();
                k--;
            }
            stack.push(currNum);
            if (k == 0) {
                while (index < num.length()) {
                    stack.push(num.charAt(index++) - '0');
                }
            }
        }
        while (k > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        for (int i = sb.length() - 1; i > 0 && sb.charAt(i) == '0'; i--) {
            sb.delete(i, i + 1);
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();

    }

    public static void main(String[] args) {
        LeeCode402 leeCode402 = new LeeCode402();
        leeCode402.removeKdigits("10",
                2);
    }
}
