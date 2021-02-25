package com.november.three;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeeCode242 {

    /**
     * 哈希表,使用数组存储，
     * 若不是小写字母就使用map来存储，最后再遍历查看是否一致
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char c : s.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 题解：只需要使用一个数组来进行存储，遍历第二个字符串的时候，在第一个存储的基础上进行-1
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            table[c - 'a']--;
        }
        for (int num : table) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
