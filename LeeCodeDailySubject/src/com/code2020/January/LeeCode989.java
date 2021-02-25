package com.code2020.January;

import java.util.ArrayList;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 **/
public class LeeCode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] B = String.valueOf(K).toCharArray();
        int preNum = 0;
        for (int i = A.length - 1, j = B.length - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = preNum + (i >= 0 ? A[i] : 0) + (j >= 0 ? B[j] - '0' : 0) % 10;
            int num = sum % 10;
            preNum = sum / 10;
            sb.append(num);
        }
        if (preNum > 0) {
            sb.append(preNum);
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            ans.add(sb.charAt(i) - '0');
        }
        return ans;
    }

}
