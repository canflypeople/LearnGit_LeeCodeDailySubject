package com.november.first;

import java.util.*;

public class LeeCode381 {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;
    /** Initialize your data structure here. */
    public LeeCode381() {
        nums = new ArrayList<>();
        idx = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);
        idx.get(lastNum).add(i);
        idx.get(lastNum).remove(nums.size() - 1);
        nums.remove(nums.size() - 1);
        if (idx.get(val).size() == 1) {
            idx.remove(val);
        } else {
            idx.get(val).remove(i);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int)(Math.random() * nums.size()));

    }
}
