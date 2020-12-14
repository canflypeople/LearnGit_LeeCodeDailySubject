package com.December;

import java.util.Arrays;

public class LeeCode204 {

    /**
     * 暴力法，枚举，（0， x的二次幂）
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = n - 1; i > 2; i--) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃式筛 x数，那么 2x,3x都为合数
     * @param n
     * @return
     */
    public int countPrimes1(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ans += 1;
                if (i * i < n) {
                    for (int j = i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }

            }
        }
        return ans;

    }

    public static void main(String[] args) {
        LeeCode204 leeCode204 = new LeeCode204();
        leeCode204.countPrimes(10);
    }
}
