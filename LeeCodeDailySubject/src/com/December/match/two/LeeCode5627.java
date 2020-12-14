package com.December.match.two;

public class LeeCode5627 {

    /**
     * 动态规划
     *
     * @param stones
     * @return
     */
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n + 1][n + 1];
        // 初始化
        dp[0][n] = dp[1][n] = dp[0][n - 1] =  0;
        for (int i = 3; i <= n; i += 2) {
            dp[i][n] = dp[i - 2][n] + stones[i - 1];
        }
        for (int i = n - 2; i >= 3; i -= 2) {
            dp[0][i] = dp[0][i + 2] + stones[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < j) {
                    if ((i + n - j) % 2 == 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + stones[i - 1], dp[i][j + 1] + stones[j - 1]);
                    }

                }
            }
        }
        int ans = dp[0][1];
        for (int i = 1; i < n; i++) {
            ans = Math.min(dp[i][i + 1], ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        LeeCode5627 leeCode5627 = new LeeCode5627();
        leeCode5627.stoneGameVII(new int[]{5,3,1,4,2});
    }
}
