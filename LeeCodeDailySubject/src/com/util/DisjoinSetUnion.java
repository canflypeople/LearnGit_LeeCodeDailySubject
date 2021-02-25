package com.util;

import java.util.Arrays;

public class DisjoinSetUnion {
    int[] f;
    int[] rank;
    int n;
    public DisjoinSetUnion(int n) {
        this.n = n;
        rank = new int[n];
        Arrays.fill(rank, 1);
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }

    public void unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return;
        }
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
        n--;
    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    public int getCount() {
        return n;
    }
}
