package com.com.code2021.com.code2021.march;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/3/8 上午9:07
 **/
public class LeeCode132 {

    int n;
    int minCut = Integer.MAX_VALUE;
    int[][] f;
    public int minCut(String s) {
        n = s.length();
        f = new int[n][n];
        backtrack(s, 0, 0);
        return minCut;
    }

    private void backtrack(String s, int i, int currCut) {
        if (i == n) {
            minCut = Math.min(minCut, currCut) - 1;
            return;
        }
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j) == 1) {
                backtrack(s, j + 1, currCut + 1);
            }
        }
    }

    private int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }

    public static void main(String[] args) {
        LeeCode132 leeCode132 = new LeeCode132();
        leeCode132.minCut("aab");
    }

}
