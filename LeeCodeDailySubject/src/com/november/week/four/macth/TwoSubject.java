package com.november.week.four.macth;

import java.util.*;

public class TwoSubject {

    public int[] mostCompetitive(int[] nums, int k) {
        Queue<int[]> priorityQueue = new PriorityQueue<int[]>(((o1, o2) -> o1[0] > o2[0] ? 1 : -1));
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            priorityQueue.add(new int[]{nums[i], i});
        }
         int[] ans = new int[k];
        int index = 0;
        while (k > 0) {
            Iterator<int[]> iterable = priorityQueue.iterator();
            while (iterable.hasNext()) {
                int[] arr = iterable.next();
                if (arr[1] < length - k) {
                    ans[index++] = arr[0];
                    iterable.remove();;
                    k--;
                    break;
                }
            }
        }
        return ans;
    }



    public int[] mostCompetitive1(int[] nums, int k) {
        List<Integer> res = mostCompetitiveList(nums, 0, k, new ArrayList<Integer>());
        int[] ans = new int[k];
        int index = 0;
        for (int num : res) {
            ans[index++] = num;
        }
        return ans;
    }

    private List<Integer> mostCompetitiveList(int[] nums, int beginIndex, int k, List<Integer> ans) {
        if (k == 0) {
            return ans;
        }
        int length = nums.length;
        if (k == length - beginIndex) {
            for (int i = beginIndex; i < length; i++) {
                ans.add(nums[i]);
            }
            return ans;
        }
        int minNum = nums[beginIndex];
        int index = beginIndex;
        for (int i = beginIndex + 1; i < length - k; i++) {
            if (nums[i] < minNum) {
                index = i;
                minNum = nums[i];
            }
        }
        ans.add(minNum);
        mostCompetitiveList(nums, index + 1, k - 1, ans);
        return ans;
    }

    public static void main(String[] args) {
        TwoSubject twoSubject = new TwoSubject();
        twoSubject.mostCompetitive(new int[]{3,5,2,6}, 2);
    }
}
