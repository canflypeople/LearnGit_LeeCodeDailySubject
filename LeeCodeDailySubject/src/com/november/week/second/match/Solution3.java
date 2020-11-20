package com.november.week.second.match;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
    int minCount = Integer.MAX_VALUE;

    public int minOperations(int[] nums, int x) {
        // 回溯
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int num : nums) {
            deque.add(num);
        }
        backtrack(x, deque, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private void backtrack(int x, Deque<Integer> deque, int count) {
        if (x == 0) {
            minCount = Math.min(minCount, count);
            return;
        } else if (x < 0) {
            return;
        } else {
            if (!deque.isEmpty()) {
                // 从头减
                int firstNum = deque.removeFirst();
                backtrack(x - firstNum, deque, count + 1);
                deque.addFirst(firstNum);

                // 从尾部减
                int lastNum = deque.removeLast();
                backtrack(x - lastNum, deque, count + 1);
                deque.addLast(lastNum);
            }
        }

    }
}
