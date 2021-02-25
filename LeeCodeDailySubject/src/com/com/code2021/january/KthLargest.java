package com.com.code2021.january;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/11 下午11:54
 **/
public class KthLargest {

    int k;
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            queue.add(num);
        }

    }

    public int add(int val) {
        queue.add(val);
        Iterator<Integer> iterator = queue.iterator();
        for (int i = 0; i < k - 1; i++) {
            iterator.next();
        }
        return iterator.next();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        kthLargest.add(3);
    }
}
