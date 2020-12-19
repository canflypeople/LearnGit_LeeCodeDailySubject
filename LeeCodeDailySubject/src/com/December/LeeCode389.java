package com.December;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 */
public class LeeCode389 {

    /**
     * 哈希表
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                return (char)(i + 'a');
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        LeeCode389 leeCode389 = new LeeCode389();
        leeCode389.findTheDifference("abcd", "abcde");
    }

}
