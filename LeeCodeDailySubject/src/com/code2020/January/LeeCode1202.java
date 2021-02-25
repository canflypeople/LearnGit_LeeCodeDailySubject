package com.code2020.January;

import com.util.DisjoinSetUnion;

import java.util.*;

/**
 * 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 */
public class LeeCode1202 {

    /**
     * 并查集 + 排序
     * 算法：
     * 1。 构建并查集
     * 2。 分类，排序
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjoinSetUnion dsu = new DisjoinSetUnion(s.length());
        for (List<Integer> pair : pairs) {
            dsu.unionSet(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int parent = dsu.find(i);
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<Character>());
            }
            map.get(parent).add(s.charAt(i));
        }
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), (c1, c2) -> c2 - c1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int x = dsu.find(i);
            List<Character> list = map.get(x);
            sb.append(list.remove(list.size() - 1));
        }
        return sb.toString();

    }

    private class UF {
        List<Integer> parents;
        List<Integer> sizes;
        Map<Integer, Integer> map;

        public UF() {
            parents = new ArrayList<>();
            sizes = new ArrayList<>();
            map = new HashMap<>();
        }

        public void union(int p, int q) {
            if (!map.containsKey(p)) {
                addNode(p);
            }
            if (!map.containsKey(q)) {
                addNode(q);
            }
            int rootP = find(p), rootQ = find(q);
            if (sizes.get(map.get(rootP)) > sizes.get(map.get(rootQ))) {
                parents.set(map.get(rootQ), map.get(rootP));
                sizes.set(map.get(rootP), sizes.get(map.get(rootP)) + sizes.get(map.get(rootQ)));
            } else {
                parents.set(map.get(rootP), map.get(rootQ));
                sizes.set(map.get(rootQ), sizes.get(map.get(rootQ)) + sizes.get(map.get(rootP)));
            }
        }

        private void addNode(int x) {
            map.put(parents.size(), x);
            parents.add(x);
            sizes.add(1);
        }

        public boolean connected(int p, int q) {
            int rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) {
                return true;
            }
            return false;
        }

        private int find(int x) {
            while (parents.get(map.get(x)) != map.get(x)) {
                parents.set(map.get(x), parents.get(parents.get(map.get(x))));
                x = parents.get(map.get(x));
            }
            return x;
        }

    }

}
