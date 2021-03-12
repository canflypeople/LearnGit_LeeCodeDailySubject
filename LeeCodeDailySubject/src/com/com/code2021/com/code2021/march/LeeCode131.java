package com.com.code2021.com.code2021.march;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 *
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 * @author: zhongmou.ji
 * @create: 2021/3/7 下午1:19
 **/
public class LeeCode131 {

    List<List<String>> ret = new ArrayList<>();
    int[][] f;
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];
        backtrack(s, 0);
        return ret;
    }

    public void backtrack(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (isPlalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                backtrack(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }

    }

    private int isPlalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPlalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];

    }
}
