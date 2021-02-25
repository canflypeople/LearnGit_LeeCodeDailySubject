package com.com.code2021.january;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * 839. 相似字符串组
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 *
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 *
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 *
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 * @author: zhongmou.ji
 * @create: 2021/1/31 下午9:27
 **/
public class LeeCode839 {
    /**
     * 并查集
     * @param strs
     * @return
     */
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (uf.isConnected(i, j)) {
                    continue;
                }
                if (isSameString(strs[i], strs[1], len)) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();


    }

    private boolean isSameString(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                ++num;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        LeeCode839 leeCode839 = new LeeCode839();
        leeCode839.numSimilarGroups(new String[]{"tars","rats","arts","star"});
    }
}


     class UnionFind {
        private int[] parents;
        private int count;
        private int n;

        public UnionFind(int n) {
            this.n = n;
            count = n;
            parents = new int[n];
            for (int i = 0; i < n; i++){
                parents[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parents[rootP] = rootQ;
            count--;
        }

        private int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return parents[x];
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public int getCount() {
            return count;
        }
    }
