package com.code2020.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class LeeCode228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(nums);
        int index = 0;
        int n = nums.length;
        while (index < n) {
            int beginIndex = index;
            while (index + 1 < n && nums[index + 1] == nums[index] + 1) {
                index++;
            }
            String rangeStr;
            if (beginIndex == index) {
                rangeStr = nums[index] + "";
            } else {
                rangeStr = nums[beginIndex] + "->" + nums[index];
            }
            ans.add(rangeStr);
            index++;
        }
        return ans;
    }
}
