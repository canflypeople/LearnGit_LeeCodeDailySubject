package com.December;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 */
public class LeeCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> wordMap1 = new HashMap<>();
        Map<Character, Character> wordMap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!wordMap1.containsKey(sChar) && !wordMap2.containsKey(tChar)) {
                wordMap1.put(sChar, tChar);
                wordMap2.put(tChar, sChar);
            } else if (wordMap1.containsKey(sChar) && wordMap2.containsKey(tChar)) {
                if (wordMap1.get(sChar) != tChar || wordMap2.get(tChar) != sChar) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;


    }
}
