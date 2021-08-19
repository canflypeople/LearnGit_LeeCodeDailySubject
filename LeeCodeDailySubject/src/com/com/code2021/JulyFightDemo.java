package com.com.code2021;

import com.com.code2021.may.TestEnum;
import com.util.TreeNode;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/7/1 上午9:38
 **/
public class JulyFightDemo {


  /**
   * LCP 07. 传递信息
   * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
   * <p>
   * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
   * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
   * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
   * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
   * <p>
   * 示例 1：
   * <p>
   * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
   * <p>
   * 输出：3
   *
   * @param n
   * @param relation
   * @param k
   * @return
   */
  public int numWays(int n, int[][] relation, int k) {
    /*
    构建图
     */
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] deliver : relation) {
      if (!graph.containsKey(deliver[0])) {
        graph.put(deliver[0], new HashSet<>());
      }
      graph.get(deliver).add(deliver[1]);
    }
    int res = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    return 1;
  }

  /**
   * 1833. 雪糕的最大数量
   * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
   * <p>
   * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
   * <p>
   * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
   * <p>
   * 注意：Tony 可以按任意顺序购买雪糕。
   * <p>
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：costs = [1,3,2,4,1], coins = 7
   * 输出：4
   * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
   *
   * @param costs
   * @param coins
   * @return
   */
  public int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);
    int res = 0;
    for (int cost : costs) {
      if (coins - cost < 0) {
        return res;
      }
      coins -= cost;
      res++;
    }
    return res;
  }

  /**
   * 645. 错误的集合
   * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
   * <p>
   * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
   * <p>
   * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
   * <p>
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [1,2,2,4]
   * 输出：[2,3]
   *
   * @param nums
   * @return
   */
  public int[] findErrorNums(int[] nums) {
    return null;
  }


  /**
   * 1711. 大餐计数
   * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
   * <p>
   * 你可以搭配 任意 两道餐品做一顿大餐。
   * <p>
   * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
   * <p>
   * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
   * <p>
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：deliciousness = [1,3,5,7,9]
   * 输出：4
   * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
   * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
   *
   * @param deliciousness
   * @return
   */
  public int countPairs(int[] deliciousness) {
    final int MOD = 1000000007;
    int maxVal = 0;
    for (int val : deliciousness) {
      maxVal = Math.max(maxVal, val);
    }
    int maxSum = maxVal * 2;
    int pairs = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int n = deliciousness.length;
    for (int i = 0; i < n; i++) {
      int val = deliciousness[i];
      for (int sum = 1; sum <= maxSum; sum <<= 1) {
        int count = map.getOrDefault(sum - val, 0);
        pairs = (pairs + count) % MOD;
      }
      map.put(val, map.getOrDefault(val, 0) + 1);
    }
    return pairs;
  }

  /**
   * 面试题 17.10. 主要元素
   * 数组中占比超过一半的元素称之为主要元素。
   * 给你一个 整数 数组，找出其中的主要元素。
   * 若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
   *
   * @param nums
   * @return
   */
  public int majorityElement(int[] nums) {
//    Map<Integer, Integer> map = new HashMap<>();
//    for (int num : nums) {
//      map.put(num, map.getOrDefault(num, 0) + 1);
//    }
//    int midLen = (nums.length % 2) == 0 ? (nums.length / 2 + 1) : ((nums.length + 1) / 2);
//    for (int num : map.keySet()) {
//      if (map.get(num) >= midLen) {
//        return num;
//      }
//    }
//    return -1;

    Arrays.sort(nums);
    int n = nums.length;
    int midLen = (nums.length % 2) == 0 ? (nums.length / 2 + 1) : ((nums.length + 1) / 2);
    int pre = nums[0];
    int count = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] == pre) {
        count++;
        if (count >= midLen) {
          return pre;
        }
      } else {
        pre = nums[i];
        count = 1;
      }
    }
    return -1;
  }

  /**
   * 275. H 指数 II
   * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
   *
   * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
   *
   *
   *
   * 示例:
   *
   * 输入: citations = [0,1,3,5,6]
   * 输出: 3
   * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
   *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
   * @param citations
   * @return
   */
  public int hIndex(int[] citations) {
    // 二分查找
    int n = citations.length;
    int low = 0, high = n - 1;
    while (low <= high) {
      int mid = ((high - low) >>> 1) + low;
      if (n - mid > citations[mid]) {
        low = mid + 1;
      } else if (n - mid <= citations[mid]) {
        high = mid - 1;
      }
    }
    return n - low;

  }

  /**
   *
   评论 (315)
   题解 (323)
   提交记录
   1846. 减小和重新排列数组后的最大元素
   给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：

   arr 中 第一个 元素必须为 1 。
   任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
   你可以执行以下 2 种操作任意次：

   减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
   重新排列 arr 中的元素，你可以以任意顺序重新排列。
   请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。



   示例 1：

   输入：arr = [2,2,1,2,1]
   输出：2
   解释：
   我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
   arr 中最大元素为 2 。
   * @param arr
   * @return
   */
  public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    Arrays.sort(arr);
    arr[0] = 1;
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      arr[i] = Math.min(arr[i], arr[i - 1] + 1);
    }
    return arr[n - 1];

  }


  /**
   * 剑指 Offer 42. 连续子数组的最大和
   * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
   *
   * 要求时间复杂度为O(n)。
   *
   *
   *
   * 示例1:
   *
   * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
   * 输出: 6
   * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    int maxSubSum = Integer.MIN_VALUE;
    int preSum = 0;
    for (int num : nums) {
      maxSubSum = Math.max(preSum + num, maxSubSum);
      preSum = preSum + num > 0 ? preSum + num : 0;
    }
    return maxSubSum;
  }


  /**
   *1877. 数组中最大数对和的最小值
   * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
   *
   * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
   * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
   *
   * nums 中每个元素 恰好 在 一个 数对中，且
   * 最大数对和 的值 最小 。
   * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
   *
   *
   *
   * 示例 1：
   *
   * 输入：nums = [3,5,2,3]
   * 输出：7
   * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
   * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
   * 示例 2：
   *
   * 输入：nums = [3,5,4,2,4,6]
   * 输出：8
   * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
   * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
   *
   *
   * 提示：
   *
   * n == nums.length
   * 2 <= n <= 105
   * n 是 偶数 。
   * 1 <= nums[i] <= 105
   * @param nums
   * @return
   */
  public int minPairSum(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    int res = Integer.MAX_VALUE;
    int left = 0, right = n - 1;
    while (left < right) {
      res = Math.max(res, nums[left] + nums[right]);
      ++left;
      --right;
    }
    return res;
  }

  public void printStringByDNA(String[] strArr) {
    Arrays.sort(strArr, (str1, str2) ->  getDNAValue(str1) <= getDNAValue(str2) ? 1 : -1);
    // print
    for (String str : strArr) {
      System.out.println(str);
    }
  }

  public int getDNAValue(String s) {
    Map<Character, Integer> charCountMap = new HashMap<>();
    int value = 0;
    int index = s.length() - 1;
    while (index >= 0) {
      value += getCharDNVValue(s.charAt(index), smallCharMap, charCountMap);
      charCountMap.put(s.charAt(index), charCountMap.getOrDefault(s.charAt(index), 0) + 1);
      --index;
    }
    System.out.println(s + ":" + value);
    return value;
  }

  private int getCharDNVValue(char c, Map<Character, List<Character>> smallCharMap, Map<Character, Integer> charCountMap) {
    return smallCharMap.get(c).stream().mapToInt(smallChar -> charCountMap.getOrDefault(smallChar, 0)).sum();
  }

  Map<Character, List<Character>> smallCharMap = new HashMap<Character, List<Character>>() {
    {
      put('A', new ArrayList<>());
      put('C', Arrays.asList('A'));
      put('G', Arrays.asList('A', 'C'));
      put('T', Arrays.asList('A', 'C', 'G'));
    }
  };

  Set<Character> set = new HashSet<Character>() {
    {
      add('A');
      add('C');
      add('T');
      add('G');
    }
  };

  /**
   * 671. 二叉树中第二小的节点
   * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
   *
   * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
   *
   * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
   * @param root
   * @return
   */
  public int findSecondMinimumValue(TreeNode root) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (!set.contains(node.val)) {
        priorityQueue.add(node.val);
        set.add(node.val);
      }
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    if (set.size() < 2) {
      return -1;
    }
    priorityQueue.poll();
    return priorityQueue.poll();
  }

  /**
   * 1104. 二叉树寻路
   * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
   *
   * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
   *
   * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
   *
   *
   *
   * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
   *
   *
   *
   * 示例 1：
   *
   * 输入：label = 14
   * 输出：[1,3,4,14]
   * @param label
   * @return
   */
  public List<Integer> pathInZigZagTree(int label) {
    List<Integer> res = new ArrayList<>();
    if (label <= 0) {
      return res;
    }
    res.add(label);
    // 求深度
    int depth = 1;
    while (label >> depth > 0) {
      ++depth;
    }
    boolean isOdd = (depth % 2 == 0);

    return res;
  }

  public int titleToNumber(String columnTitle) {
    int res = 0;
    for (char c : columnTitle.toCharArray()) {
      res += c;
    }
    return res;

  }

  /**
   * 611. 有效三角形的个数
   * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
   *
   * 示例 1:
   *
   * 输入: [2,2,3,4]
   * 输出: 3
   * 解释:
   * 有效的组合是:
   * 2,3,4 (使用第一个 2)
   * 2,3,4 (使用第二个 2)
   * 2,2,3
   * 注意:
   *
   * 数组长度不超过1000。
   * 数组里整数的范围为 [0, 1000]。
   * @param nums
   * @return
   */
  public int triangleNumber(int[] nums) {
    /*
    分析： 两边之和大于第三边
     */
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 2; j < n; j++) {
        // 差值 nums[j] - nums[i] < x < nums[i] + nums[j], 查找小于等于x的值
        int left = nums[i], right = nums[j];

      }
    }
    return 1;

  }





  public static void main(String[] args) {
    TestEnum testEnum = TestEnum.TEST1;
    System.out.println(Objects.equals(testEnum, TestEnum.TEST1));
    JulyFightDemo julyFightDemo = new JulyFightDemo();
    julyFightDemo.printStringByDNA(new String[]{"TAAAAA", "ATAACA", "AGT"});
    julyFightDemo.majorityElement(new int[]{3, 2, 3});
  }

}
