package com.December;

import java.util.*;

/**
 * 621. 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间
 */
public class LeeCode621 {

    /**
     * 贪心算法，队列
     * 步骤：
     * 1。 统计数组中需要工作的单元和单元出现的次数
     * 2。 选择不再冷却中且剩余执行次数最多的那个任务
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int m = freq.size();
        // 下一次可以出现的time，用作表示冷却时间
        List<Integer> nextValid = new ArrayList<>();
        // 当前字符还剩下几个待处理任务
        List<Integer> rest = new ArrayList<>();
        // 获取哈希表，将里面出现的字符放入set中，
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            nextValid.add(1);
            rest.add(entry.getValue());
        }
        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;
            // 获取不再冷却的任务的时间
            int minNextValid = Integer.MIN_VALUE;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.max(minNextValid, rest.get(j));
                }
            }
            // 设置时间
            time = Math.max(time, minNextValid);
            //
            int best = -1;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) < rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + 1);
            rest.set(best , rest.get(i) - 1);
        }
        return time;
    }
}
