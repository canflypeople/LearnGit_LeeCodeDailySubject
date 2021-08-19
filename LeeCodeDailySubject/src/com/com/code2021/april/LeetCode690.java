package com.com.code2021.april;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/1 上午11:25
 **/
public class LeetCode690 {

  public int getImportance(List<Employee> employees, int id) {
    // 哈希表
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Map<Integer, Integer> importanceMap = new HashMap<>();
    for (Employee employee : employees) {
      Set<Integer> set = new HashSet<>();
      for (int subEmployeeId : employee.subordinates) {
        set.add(subEmployeeId);
      }
      map.put(employee.id, set);
      importanceMap.put(employee.id, employee.importance);
    }
    return getImportance(map, importanceMap, id);
  }

  private int getImportance(Map<Integer, Set<Integer>> map, Map<Integer, Integer> importanceMap, int id) {
    int res = importanceMap.get(id);
    for (Integer subEmployeeId : map.get(id)) {
      res += getImportance(map, importanceMap, subEmployeeId);
    }
    return res;
  }


  public boolean splitString(String s) {
    // 回溯
    // 寻找符合的排列组合

    // 动态规划
    // dp[i] i下标 j当前值
    return true;

  }

  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> map = new HashMap<>();
    for (List<Integer> row : wall) {
      int currLen = 0;
      for (int i = 0; i < row.size() - 1; i++) {
        currLen += row.get(i);
        map.put(currLen, map.getOrDefault(currLen, 0) + 1);
      }
    }
    int minCount = Integer.MIN_VALUE;
    for (int count : map.values()) {
      minCount = Math.max(count, minCount);
    }
    return minCount == Integer.MIN_VALUE ? wall.size() : wall.size() - minCount;
  }

  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE * 10) {
        return 0;
      }
      int digit = x % 10;
      x %= 10;
      rev = rev * 10 + digit;
    }
    return rev;
  }

  public int deleteAndEarn(int[] nums) {
    // 动态规划
    int maxValue = 0;
    for (int num : nums) {
      maxValue = Math.max(num, maxValue);
    }
    int[] sum = new int[maxValue + 1];
    for (int num : nums) {
      sum[num] += num;
    }
    return rob(sum);
  }

  private int rob(int[] nums) {
    int size = nums.length;
    // second 存储的是当前最大的结果
    int first = nums[0], second = Math.max(nums[0], nums[1]);
    for (int i = 2; i < size; i++) {
      int temp = second;
      second = Math.max(first + nums[i], second);
      first = temp;
    }
    return second;
  }

  public static void main(String[] args) {
    LeetCode690 leetCode690 = new LeetCode690();
    leetCode690.deleteAndEarn(new int[]{3,4,2});
  }


}

class Employee {
  public int id;
  public int importance;
  public List<Integer> subordinates;
}
