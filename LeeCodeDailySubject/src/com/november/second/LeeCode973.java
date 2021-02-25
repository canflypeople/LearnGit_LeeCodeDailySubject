package com.november.second;

import java.util.*;

public class LeeCode973 {
    public int[][] kClosest(int[][] points, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] point : points) {
            int sqrt = getSqrt(point[0], point[1]);
            List<int[]> list = map.getOrDefault(sqrt, new ArrayList<>());
            list.add(new int[]{point[0], point[1]});
            map.put(sqrt, list);
        }
        Queue<Map.Entry<Integer, List<int[]>>> queue = new PriorityQueue<Map.Entry<Integer, List<int[]>>>((o1, o2) -> o1.getKey() - o2.getKey());
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            queue.offer(entry);
        }
        int[][] ans = new int[K][2];
        int index = 0;
        while (index < K) {
            List<int[]> list = queue.poll().getValue();
            for (int[] point : list) {
                ans[index++] = new int[]{point[0], point[1]};
            }
        }
        return ans;


    }

    public int getSqrt(int x, int y) {
        return (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
    }

    public static void main(String[] args) {
        LeeCode973 leeCode973 = new LeeCode973();
        leeCode973.kClosest(new int[][]{new int[]{1,3}, new int[]{-2, 2}}, 1);
    }


}
