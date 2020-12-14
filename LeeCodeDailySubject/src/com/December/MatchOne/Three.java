package com.December.MatchOne;

import java.math.BigDecimal;

/**
 * 5620. 连接连续二进制数字 显示英文描述
 * 通过的用户数148
 * 尝试过的用户数189
 * 用户总通过次数148
 * 用户总提交次数224
 * 题目难度Medium
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 */
public class Three {

    public int concatenatedBinary(int n) {
        StringBuilder preNum = new StringBuilder("0");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            preNum = getBinary(preNum);
            sb.append(preNum);
            System.out.println(preNum);
        }
        BigDecimal res = new BigDecimal(sb.toString());
        System.out.println(res);
        BigDecimal divideNum = new BigDecimal(10e9 + 7);
        BigDecimal[] arr = res.divideAndRemainder(divideNum);
        System.out.println(arr[0]);
        System.out.println(res.divideAndRemainder(divideNum)[1].intValue());
        return res.divideAndRemainder(divideNum)[1].intValue();
    }

    private StringBuilder getBinary(StringBuilder num) {
        int pre = 1;
        StringBuilder res = new StringBuilder();
        int i = num.length() - 1;
        for (; pre == 1 ; --i) {
            int curr = i >= 0 ? num.charAt(i) - '0' : 0;
            if (pre + curr == 2) {
                res.append(0);
            } else {
                res.append(1);
                pre = 0;
            }
        }
        if (i > -1) {
            res.append(new StringBuilder(num.subSequence(0, i + 1)).reverse());
        }
        return res.reverse();

    }

    public static void main(String[] args) {
        Three three = new Three();
        three.concatenatedBinary(3);
    }

}
