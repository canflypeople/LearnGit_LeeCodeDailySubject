package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution02 {

    public static int getTruth(int n, int[][] trusts) {
        int[] counts = new int[n + 1];
        Arrays.fill(counts, n);
        for (int[] trust : trusts) {
            counts[trust[1]]--;
        }
        for (int i = 1; i <= n; i++) {
            if (counts[i] == 1) {
                return i;
            }
        }
        return -1;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 1; i <= n; i++) {
//            set.add(i);
//        }
//        for (int[] trust : trusts) {
//            if (set.contains(trust[0])) {
//                set.remove(trust[0]);
//            }
//        }
//        if (set.size() == 1) {
//            int truther = 0;
//            Iterator<Integer> iterable = set.iterator();
//            while (iterable.hasNext()) {
//                truther = iterable.next();
//            }
//            Set<Integer> trustSet = new HashSet<>();
//            for (int i = 1; i <= n; i++) {
//                trustSet.add(i);
//            }
//            trustSet.remove(truther);
//            for (int[] trust : trusts) {
//                if (trust[1] == truther) {
//                    if (trustSet.contains(trust[0])) {
//                        trustSet.remove(trust[0]);
//                    }
//                }
//            }
//            return trustSet.isEmpty() ? truther : -1;
//        } else {
//            return -1;
//        }
    }

    public static void main(String[] args) {
        System.out.println(getTruth(2, new int[][]{new int[]{1, 2}}));

    }
}
