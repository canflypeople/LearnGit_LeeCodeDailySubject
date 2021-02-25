package com.november.first;

import java.util.*;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 */
public class LeeCode1356 {

    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] bits = new int[10001];
        for (int x : arr) {
            list.add(x);
            bits[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bits[o1] != bits[o2]) {
                    return bits[o1] - bits[o2];
                } else {
                    return o1 - o2;
                }
            }
        });
        int[] ans = new int[arr.length];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private int get(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 2;
            num /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeeCode1356 leeCode1356 = new LeeCode1356();
        leeCode1356.sortByBits(new int[]{0,1,2,3,4,5,6,7,8});
    }
}
