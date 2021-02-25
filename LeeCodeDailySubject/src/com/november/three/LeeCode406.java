package com.november.three;

import java.util.Arrays;

public class LeeCode406 {

    public int[][] reconstructQueue(int[][] people) {
        // 计数排序
        int[] count = new int[1101];
        for (int[] num : people) {
            count[num[0] + num[1]]++;
        }
        int pre = count[0];
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[][] ans = new int[people.length][2];
        for (int i = people.length; i >= 0; i++) {
            ans[--count[people[i][0] + people[i][1]]] = new int[]{people[i][0], people[i][1]};
        }
        return ans;


    }
}
