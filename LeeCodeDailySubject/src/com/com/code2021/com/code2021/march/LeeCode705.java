package com.com.code2021.com.code2021.march;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/3/13 下午10:15
 **/
public class LeeCode705 {



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}

class MyHashSet {
    List<Integer>[] data;
    private static final int BASE = 765;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (key == element) {
                return;
            }
        }
        data[h].add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (key == element) {
                iterator.remove();
                return;
            }
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (key == element) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}

class MyHashMap {
    List<Pair<Integer, Integer>>[] data;
    private final static int BASE = 100_000;

    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new ArrayList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair<Integer, Integer>> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair<Integer, Integer> pair = iterator.next();
            int currKey = pair.getKey();
            if (currKey == key) {
                pair.setValue(value);
                return;
            }
        }
        data[h].add(new Pair<>(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        Iterator<Pair<Integer, Integer>> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair<Integer, Integer> pair = iterator.next();
            int currKey = pair.getKey();
            if (currKey == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair<Integer, Integer>> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair<Integer, Integer> pair = iterator.next();
            int currKey = pair.getKey();
            if (currKey == key) {
                iterator.remove();
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
