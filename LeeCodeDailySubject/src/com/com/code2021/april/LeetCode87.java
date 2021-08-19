package com.com.code2021.april;

import com.util.TreeNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program:
 * @description:
 * 87. 扰乱字符串
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * @author: zhongmou.ji
 * @create: 2021/4/16 下午2:23
 **/
public class LeetCode87 {
  public boolean isScramble(String s1, String s2) {
    return true;
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    // 滑动窗口, 指定区域中的, 有序集合, 判断是否符合条件
    TreeSet<Long> set = new TreeSet<Long>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      Long ceil = set.ceiling((long) nums[i] - (long) t);
      if (ceil != null && ceil <= (long) nums[i] + (long) t) {
        return true;
      }
      set.add((long) nums[i]);
      if (i >= k) {
        set.remove((long) nums[i - k]);
      }
    }
    return false;


  }


  public int[] getOrder(int[][] tasks) {
    int n = tasks.length;
    int[] ans = new int[n];
    int[][] copyTasks = new int[n][3];
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
            (o1, o2) -> o1[1] == o2[1] ? (o1[2] > o2[2] ? 1 : -1) : o1[1] - o2[1]);
    for (int i = 0; i < n; i++) {
      copyTasks[i][0] = i;
      copyTasks[i][1] = tasks[i][0];
      copyTasks[i][2] = tasks[i][1];
      queue.offer(copyTasks[i]);
    }
    int currTime = 0;
    return null;
    // 最小堆， 排序， 进入时间， 耗时， 下标


  }


  // 后一个结果是由前一个结果推导出来的
  public int numDecodings(String s) {
    // dp[i][2] i表示当前的位置， j表示当前是第一个， 还是第二个结尾
    // dp[i][0] = (dp[i - 1][0]) + dp[i- 1][1]
    // dp[i][1] = (dp[i - 1][0] + s[i - 1] > 2 && s[i] <= 6)
    int len = s.length();
    if (len <= 0) {
      return 0;
    }
    int[][] dp = new int[len + 1][2];
    dp[0][0] = 0;
    dp[0][1] = 0;
    if (s.charAt(0) > '0') {
      dp[1][0] = 1;
    }
    for (int i = 1; i < len; i++) {
      dp[i + 1][0] = dp[i][0] + dp[i][1];
      dp[i + 1][1] = (s.charAt(i - 1) - '0' < 2 || (s.charAt(i - 1) - '0' == 2 && s.charAt(i) - '0' <= 6)) ? 1 : 0;
    }
    return dp[len][0] + dp[len][1];
  }


  TreeNode dummyNode;
  public TreeNode increasingBST(TreeNode root) {
    dummyNode = new TreeNode(-1);
    TreeNode resNode = dummyNode;
    // 中序遍历
    inorder(root);
    return resNode.right;
  }

  public void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    dummyNode.right = root;
    dummyNode.left = null;
    dummyNode = root;
    inorder(root.right);
  }

  public int sumBase(int n, int k) {
    int res = 0;
    while (n > 0) {
      res += n % k;
      n /= k;
    }
    return res;
  }


  public int maxFrequency(int[] nums, int k) {
    // dp？
    // 贪心， 选消耗最小的
//    int n = nums.length;
//    if (n == 0) {
//      return 0;
//    }
//    int res = 1;
//    int[][] instances = new int[n][n];
//    for (int i = 0; i <= n; i++) {
//      Arrays.fill(instances[i], -1);
//    }
//    for (int i = n - 1; i >= 1; i--) {
//      int diffSum = 0;
//      int j = i;
//      for (; j >= 0; j--) {
//        if (instances[i][j] == -1) {
//          instances[i][j] = nums[i] - nums[j];
//        }
//        if (diffSum + instances[i][j] > k) {
//          break;
//        } else {
//          diffSum += instances[i][j];
//        }
//      }
//      res = Math.max(res, i - j + 1);
//    }
//    return res;
    // 前缀和
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int res = 1;
    int[] preSum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
    }
    for (int i = n - 1; i >= 1; i--) {
      // 二分法
      int left = 0, right = i - 1;
      while (left <= right) {
        int mid = (right - left) / 2 + left;
        int preDiff = preSum[i] - preSum[mid];
        int diffSum = nums[i] * (i - mid) - preDiff;
        if (diffSum > k) {
          left = mid + 1;
        } else if (diffSum < k) {
          if (left == right) {
            res = Math.max(res, i - mid + 1);
            break;
          }
          right = mid;
        } else if (diffSum == k) {
          res = Math.max(res, i - mid + 1);
          break;
        }
      }
    }
    return res;
  }

  Map<String, Set<String>> map = new HashMap<>();

  /**
   * 贪心+ 二分查找
   * @param weights
   * @param D
   * @return
   */
  public int shipWithinDays(int[] weights, int D) {
    // 边界， 根据边界缩小范围
    int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
    // 查看当前的运力是否能满足要求， 不满意则移动
    while (left < right) {
      int mid = (right - left) / 2 + left;
      // need为天数
      int need = 1;
      // 当天已放入的重量
      int currWeight = 0;
      for (int weight : weights) {
        if (currWeight + weight > mid) {
          need++;
          currWeight = 0;
        }
        currWeight += weight;
      }
      if (need <= D) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    LeetCode87 leetCode87 = new LeetCode87();
    leetCode87.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5 );
//    leetCode87.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu");
    leetCode87.maxFrequency(new int[]{3,9,6}, 2);
  }
}
