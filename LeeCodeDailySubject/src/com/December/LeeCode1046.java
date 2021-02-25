package com.December;

import java.util.PriorityQueue;

public class LeeCode1046 {


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o1 < o2 ? 1 : -1);
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        while (queue.size() >= 2) {
            int bigStone = queue.poll();
            int smallStone = queue.poll();
            if (bigStone != smallStone) {
                queue.offer(bigStone - smallStone);
            }
        }
        return queue.size() == 1 ? queue.poll() : 0;

    }

    public static void main(String[] args) {
        LeeCode1046 leeCode1046 = new LeeCode1046();
        leeCode1046.lastStoneWeight(new int[]{1});
    }
}
