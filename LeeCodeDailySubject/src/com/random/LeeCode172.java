package com.random;

import java.math.BigDecimal;

/**
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class LeeCode172 {

    /**
     * 统计5， 10的个数
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 10) {
            count += 2;
            n /= 10;
        }
        return count + (n > 5 ? 1 : 0);

    }

    public int getSum(int a, int b) {
        BigDecimal bigDecimal1 = new BigDecimal(a);
        BigDecimal bigDecimal2 = new BigDecimal(b);
        return bigDecimal1.add(bigDecimal2).intValue();
    }
}
