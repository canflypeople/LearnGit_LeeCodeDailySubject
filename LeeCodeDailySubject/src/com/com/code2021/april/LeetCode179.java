package com.com.code2021.april;


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/4/12 上午9:41
 **/
public class LeetCode179 {

  public String largestNumber(int[] nums) {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            (o1, o2) -> compare(String.valueOf(o1), String.valueOf(o2))
    );
    for (int num : nums) {
      queue.offer(num);
    }
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      sb.append(queue.poll());
    }
    return sb.toString();
  }

  public int compare(String str1, String str2) {
    int index = 0;
    int len1 = str1.length(), len2 = str2.length();
    int minLen = Math.min(len1, len2);
    while (index < minLen) {
      if (str1.charAt(index) != str2.charAt(index)) {
        return str2.charAt(index) - str1.charAt(index) == 0 ? 1 : 1 ;
      }
      index++;
    }
    if (len1 > len2) {
      return str2.charAt(index - 1) - str1.charAt(index);
    } else if (len1 < len2) {
      return str2.indexOf(index) - str1.charAt(index - 1);
    }
    return 1;
  }

  public int nthUglyNumber(int n) {
    int[] factors = new int[]{2, 3, 5};
    Set<Long> seen = new HashSet<>();
    PriorityQueue<Long> heap = new PriorityQueue<>((o1, o2) -> o1 > o2 ? 1 : -1);
    heap.offer(1L);
    seen.add(1L);
    int ugly = 0;
    for (int i = 0; i < n; i++) {
      long curr = heap.poll();
      ugly = (int) curr;
      for (int factor : factors) {
        long next = factor * curr;
        seen.add(next);
        heap.offer(next);
      }
    }
    return ugly;
  }

  public int nthUglyNumber1(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int p2 = 1, p3 = 1, p5 = 1;
    for (int i = 2; i <= n; i++) {
      int num2 = p2 * 2, num3 = p3 * 3, num5 = p5 * 5;
      dp[i] = Math.min(Math.min(num2, num3), num5);
      if (dp[i] == num2) {
        p2++;
      }
      if (dp[i] == num3) {
        p3++;
      }
      if (dp[i] == num5) {
        p5++;
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    LeetCode179 leetCode179 = new LeetCode179();
    leetCode179.largestNumber(new int[]{8308,8308,830});
  }
}
