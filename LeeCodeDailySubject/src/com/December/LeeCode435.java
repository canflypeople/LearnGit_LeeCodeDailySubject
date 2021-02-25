package com.December;

import java.util.PriorityQueue;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */
public class LeeCode435 {

    /**
     * 贪心算法
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int count = 0;
        while (priorityQueue.size() > 1) {
            int[] first = priorityQueue.poll();
            int[] second = priorityQueue.peek();
            if (first[1] > second[0]) {
                count++;
            }
        }
        return count;
    }
}
