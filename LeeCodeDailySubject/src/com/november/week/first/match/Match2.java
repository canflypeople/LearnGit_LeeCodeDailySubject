package com.november.week.first.match;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.*;

public class Match2 {
    public int minDeletions(String s) {
        int[] charCount = new int[26];
        Arrays.fill(charCount, 0);
        int deletes = 0;
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int count : charCount) {
            if (count != 0) {
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }
        Arrays.sort(charCount);
        for (int i = 0; i < 26; i++) {
            int count = charCount[i];
            if (count == 0) {
                continue;
            }
            if (map.get(count) > 1) {
                while (map.containsKey(count)) {
                    count--;
                }
                if (count != 0) {
                    map.put(count, 1);
                }
                map.put(charCount[i], map.get(charCount[i]) - 1);
                deletes += charCount[i] - count;
            }
        }
        return deletes;

    }

    public static void main(String[] args) {
        Match2 match2 = new Match2();
        match2.minDeletions("aaabbbcc");
    }
}
