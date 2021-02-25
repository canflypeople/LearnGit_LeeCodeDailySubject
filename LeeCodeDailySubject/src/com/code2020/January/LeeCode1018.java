package com.code2020.January;

import java.util.ArrayList;
import java.util.List;

/**
 *1018. 可被 5 整除的二进制前缀
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 */
public class LeeCode1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<Boolean>();
        int num = 0;
        for (int i = 0; i <= A.length - 1; i++) {
            num = num * 2 + (A[i] == 0 ? 0 : 1);
            ans.add((num % 5 == 0 ? true : false));
            num = num % 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeeCode1018 leeCode1018 = new LeeCode1018();
        leeCode1018.prefixesDivBy5(new int[]{1,1,0,0,0,1,0,0,1});
    }
}
