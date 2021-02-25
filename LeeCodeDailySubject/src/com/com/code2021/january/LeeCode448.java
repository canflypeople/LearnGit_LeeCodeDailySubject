package com.com.code2021.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description:
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 * @author: zhongmou.ji
 * @create: 2021/2/13 上午11:57
 **/
public class LeeCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int value = 1;
        int n = nums.length;
        for (int num : nums) {
            if (value == num) {
                value++;
                continue;
            } else if (value > num) {
                continue;
            }
            while (value < num) {
                ans.add(value);
                value++;
            }
            value++;
        }
        if (value != n) {
            while (value <= n) {
                ans.add(value);
                value++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeeCode448 leeCode448 = new LeeCode448();
        leeCode448.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}
