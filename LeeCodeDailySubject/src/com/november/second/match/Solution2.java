package com.november.second.match;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        Map<Integer, Set<Integer>> map2 = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] != 0) {
                Set<Integer> set = map1.getOrDefault(count1[i], new HashSet<>());
                set.add(i);
                map1.put(count1[i], set);
                set1.add(i);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count2[i] != 0) {
                Set<Integer> set = map2.getOrDefault(count2[i], new HashSet<>());
                set.add(i);
                map2.put(count2[i], set);
                set2.add(i);
            }
        }
        for (int c : set1) {
            if (!set2.contains(c)) {
                return false;
            }
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map1.entrySet()) {
            int key = entry.getKey();
            Set<Integer> value = entry.getValue();
            if (!map2.containsKey(key) || map2.get(key).size() != value.size()) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.closeStrings("abc", "bca");
    }
}
