package com.com.code2021.february;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program:
 * @description:
 * 1178. 猜字谜
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 * @author: zhongmou.ji
 * @create: 2021/2/26 下午11:45
 **/
public class LeeCode1178 {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // 构建words，让word去匹配puzzles
        List<Integer> ans = new ArrayList<>();
        List<Pair<Character, Set<Character>>> pairs = new ArrayList<>();
        for (String word : words) {
            char firstChar = word.charAt(0);
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            Pair<Character, Set<Character>> pair = new Pair<>(firstChar, set);
            pairs.add(pair);
        }
        for (String puzzle : puzzles) {
            int num = 0;
            for (Pair<Character, Set<Character>> pair : pairs) {
                Set<Character> copySet = new HashSet<>(pair.snd);
                if (puzzle.charAt(0) != pair.fst) {
                    continue;
                }
                for (char c : puzzle.toCharArray()) {
                    copySet.remove(c);
                }
                if (copySet.isEmpty()) {
                    num++;
                }
            }
            ans.add(num);
        }
        return ans;
    }

    class Pair<A, B> {
        public A fst;
        public B snd;
        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }

    public static void main(String[] args) {
        LeeCode1178 leeCode1178 = new LeeCode1178();
        leeCode1178.findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"});
    }
}
