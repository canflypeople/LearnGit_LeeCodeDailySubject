package com.December;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 提交记录
 659. 分割数组为连续子序列
 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。

 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 */
public class LeeCode659 {
    private static final int LEASTLENGTH = 3;

    /**
     * 哈希表 + 最小堆
     * 思考：
     * 1。 要将x放入哈希表中，
     * 若哈希表中存在x-1的长度为k的子序列，就将x放入x-1的堆中，得到长度为k+1，以x结尾的子序列
     * 若不存在，则新建一个以x结尾的，长度为1的子序列
     * 2。 若存在多个x-1的子序列，那么x要放入哪一个子序列，因为要求子序列长度最小为3，则需要放入长度最短的子序列
     * 算法：
     * 1。 使用map存储堆，key为以x结尾， value为堆，优先队列，存储的是子字符串的长度
     * 2。 遍历数组，尝试将当前值让入堆中，若堆中存在x-1，则将当前值放入x-1的最小堆中，更新其长度，若不存在则新增以x结尾的最小堆
     * 3。 遍历map中的堆，若存在长度小于3的则返回false，否则则true
     *
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<Integer>());
            }
            if (map.containsKey(num - 1)) {
                int prevLength = map.get(num - 1).poll();
                if (map.get(num - 1).size() == 0) {
                    map.remove(num - 1);
                }
                map.get(num).offer(prevLength + 1);

            } else {
                map.get(num).offer(1);
            }
        }

        for (PriorityQueue<Integer> priorityQueue : map.values()) {
            for (int length : priorityQueue) {
                if (length < LEASTLENGTH) {
                    return false;
                }
            }
        }
        return true;

    }


}
