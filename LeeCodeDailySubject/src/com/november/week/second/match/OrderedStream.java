package com.november.week.second.match;

import java.util.*;

public class OrderedStream {

    String[] arr;
    int pre;

    public OrderedStream(int n) {
        arr = new String[n + 1];
        pre = 1;
    }

    public List<String> insert(int id, String value) {
        arr[id] = value;
        List<String> ans = new ArrayList<>();
        for (int i = pre; i < arr.length && arr[i] != null; i++) {
            ans.add(arr[i]);
        }
        pre++;
        return ans;

    }
}
