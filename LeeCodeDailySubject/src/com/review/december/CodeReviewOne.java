package com.review.december;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2020/12/07 - 2020/12//12 每日一题及周赛复习
 */
public class CodeReviewOne {

    /**
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ans.get(i).add(1);
                } else {
                    ans.get(i).add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
        }
        return ans;
    }

    /**
     * 861. 翻转矩阵后的得分
     * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
     *
     * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
     *
     * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
     *
     * 返回尽可能高的分数。
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        // 贪心，不理解的是：我感觉有两种情况，第一种反转第一列，第二种不翻转第一列，
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += 1 - A[i][j];
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - 1 - j));
        }
        return ret;


    }

    /**
     * 842. 将数组拆分成斐波那契序列
     * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     *
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     *
     * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     * F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     *
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        // 回溯
        List<Integer> list = new ArrayList<>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;

    }

    private boolean backtrack(List<Integer> list, String s, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && s.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + s.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (sum < curr) {
                    break;
                } else if (sum > curr) {
                    continue;
                }
            }
            list.add(curr);
            if (backtrack(list, s, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    /**
     * 62. 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // 动态规划
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

    /**
     * 860. 柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     *
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        // 贪心算法
        int[] changes = new int[2]; // 0记录5零钱的个数，1记录10零钱的个数
        for (int bill : bills) {
            if (bill == 5) {
                ++changes[0];
            } else if (bill == 10) {
                if (changes[0] == 0) {
                    return false;
                }
                --changes[0];
                ++changes[1];
            } else if (bill == 20) {
                if (changes[1] > 0 && changes[0] > 0) {
                    --changes[0];
                    --changes[1];
                } else if (changes[0] > 0) {
                    if (changes[0] < 3) {
                        return false;
                    }
                    changes[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return false;


    }

    /**
     * 649. Dota2 参议院
     * Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
     *
     * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
     *
     * 禁止一名参议员的权利：
     *
     * 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
     *
     * 宣布胜利：
     *
     *           如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
     *
     *
     *
     * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
     *
     * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
     *
     * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        // 队里 FIFO
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return radiant.isEmpty() ? "Radiant" : "Dire";

    }

    /**
     * 376. 摆动序列
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
     *
     * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     *
     * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        // 贪心算法
        int ans = 0;
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        ans += prevdiff == 0 ? 0 : 2;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <=0 ) || (diff < 0 && prevdiff >= 0)) {
                 ++ans;
                 prevdiff = diff;
            }
        }
        return ans;
    }

    /**
     * Match
     */

    /**
     * 5627. 石子游戏 VII
     * 石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
     *
     * 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
     *
     * 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
     *
     * 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
     * @param stones
     * @return
     */
    public int stoneGameVII(int[] stones) {
        return 1;

    }
}
