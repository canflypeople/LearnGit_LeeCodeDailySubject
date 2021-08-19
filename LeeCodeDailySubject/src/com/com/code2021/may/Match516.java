package com.com.code2021.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/16 上午10:31
 **/
public class Match516 {

  int res = 0;
  public int subsetXORSum(int[] nums) {
    res = 0;
    backtrack(nums, nums.length, 0, 0);
    return res;
  }

  private void backtrack(int[] nums, int length, int index, int xor) {
    res += xor;
    if (length == index) {
      return;
    }
    for (int i = index; i < length; i++) {
      backtrack(nums, length, i + 1, xor ^ nums[i]);
    }
  }


  public int minSwaps(String s) {
    int oddOne = 0, nounOne = 0;
    int oddZero = 0, nounZero = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '0') {
        if (i % 2 == 0) {
          nounZero++;
        } else {
          oddZero++;
        }
      } else {
        if (i % 2 == 0) {
          nounOne++;
        } else {
          oddOne++;
        }
      }
    }
    int oneCount = oddOne + nounOne, zeroCount = oddZero + nounZero;
    if (n % 2 == 0) { // 偶数
      if (oneCount != zeroCount) {
        return -1;
      }
      return Math.min(Math.min(oddOne, nounOne), Math.min(oddZero, nounZero));

    } else {
      if (Math.abs(oneCount - zeroCount) != 1) {
        return -1;
      }
      // 多的下标必须在偶数
      if (oneCount > zeroCount) {
        return oddOne;
      } else {
        return oddZero;
      }
    }
  }

  class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
      this.nums1 = nums1;
      this.nums2 = nums2;
      for (int num : nums2) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
    }

    public void add(int index, int val) {
      if (map.get(nums2[index]) == 1) {
        map.remove(nums2[index]);
      } else {
        map.put(nums2[index], map.get(nums2[index]) - 1);
      }
      nums2[index] += val;
      map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    /**
     * 计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目
     * （0 <= i < nums1.length 且 0 <= j < nums2.length）
     *
     * i * j
     * @param tot
     * @return
     */
    public int count(int tot) {
      int res = 0;
      for (int num : nums1) {
        res += map.getOrDefault(tot - num, 0);
      }
      return res;
    }
  }

  static class FindSumPairs1 {
    int[] nums1;
    int[] nums2;

    public FindSumPairs1(int[] nums1, int[] nums2) {
      this.nums1 = nums1;
      Arrays.sort(nums1);
      this.nums2 = nums2;
    }

    public void add(int index, int val) {
      nums2[index] += val;
    }

    /**
     * 计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目
     * （0 <= i < nums1.length 且 0 <= j < nums2.length）
     *
     * i * j
     * @param tot
     * @return
     */
    public int count(int tot) {
      int ans = 0;
      for (int i = 0; i < nums2.length; i++) {
        ans += twoPointSearch(tot - nums2[i]);
      }
      return ans;
    }

    private int twoPointSearch(int target) {
      int ans = 0;
      int left = 0, right = nums1.length - 1;
      while (left <= right) {
        int mid = (left + right) / 2 - left;
        int val = nums1[mid];
        if (val == target) {
          ans++;
          int leftIdx = mid - 1;
          while (leftIdx >= 0 && nums1[leftIdx] == target) {
            ans++;
            leftIdx--;
          }
          int rightIdx = mid + 1;
          while (rightIdx < nums1.length && nums1[rightIdx] == target) {
            ans++;
            rightIdx++;
          }
          return ans;
        } else if (val > target) {
          right = mid - 1;
        } else if (val < target) {
          left = mid + 1;
        }
      }
      return ans;
    }
  }

  /**
   * Your FindSumPairs object will be instantiated and called as such:
   * FindSumPairs obj = new FindSumPairs(nums1, nums2);
   * obj.add(index,val);
   * int param_2 = obj.count(tot);
   */

  /**
   * [7],[3,2],[8],[4],[0,1],[1,1],[7]]
   * @param args
   */

  public static void main(String[] args) {
    Match516 match516 = new Match516();
    Match516.FindSumPairs1 a = new FindSumPairs1(new int[]{1,1,2,2,2,3}, new int[]{1,4,5,2,5,4});
    a.count(7);
    a.add(3, 2);
    a.count(8);
    a.count(4);
    a.add(0, 1);
    a.add(1, 1);
    a.count(7);
  }
}
