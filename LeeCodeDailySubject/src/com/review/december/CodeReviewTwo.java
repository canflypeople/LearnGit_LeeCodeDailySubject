package com.review.december;

import java.util.*;

/**
 * 2020/12/13 - 2020/12//19 每日一题及周赛复习
 */
public class CodeReviewTwo {

    /**
     *217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     * 算法：哈希表
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return true;
    }


    /**
     * 49. 字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 算法：哈希表
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortStr = new String(arr);
            if (map.containsKey(sortStr)) {
                res.get(map.get(sortStr)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
                map.put(sortStr, res.size() - 1);
            }
        }
        return res;
    }


    /**
     * 738. 单调递增的数字
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
     *
     * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
     *
     * 贪心算法：
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i++;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1]--;
                i--;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));

    }

    /**
     * 290. 单词规律
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 算法：散列表
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> wordId = new HashMap<>();
        Map<Character, String> idWord = new HashMap<>();
        String[] strs = s.split(" ");
        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            String str = strs[i];
            if (!wordId.containsKey(c) && !idWord.containsKey(str)) {
                wordId.put(str, c);
                idWord.put(c, str);
            } else if (wordId.getOrDefault(str, ' ') != c || idWord.getOrDefault(c, " ") != str) {
                return false;
            }
        }
        return true;
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 算法： 动态规划 / 贪心算法+补偿机制
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int own = -prices[0];
        int empty = 0;
        for (int i = 1; i < prices.length; i++) {
            own = Math.max(own, empty - prices[i]);
            empty = Math.max(empty, own + prices[i] - fee);
        }
        return empty;

    }

    /**
     * 389. 找不同
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : t.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return c;
            }
        }
        return 'a';
    }

    /**
     * 48. 旋转图像
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][i] = matrix[n - i - 1][j];
            }
        }
        matrix = newMatrix;
    }

}
