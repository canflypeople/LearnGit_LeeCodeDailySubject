package com.com.code2021.february;

/**
 * @program:
 * @description:
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * @author: zhongmou.ji
 * @create: 2021/2/23 上午9:01
 **/
public class LeeCode1052 {
    /*
    滑动窗口，获取区段间能避免减少的最大满意度
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = grumpy.length;
        int left = 0, right = 0;
        int currSatisfied = 0;
        int satisfiedSum = 0;
        currSatisfied += grumpy[right] == 1 ? customers[right] : 0;
        while (right - left + 1 < X) {
            satisfiedSum += grumpy[right] == 0 ? customers[right] : 0;
            right++;
            currSatisfied += grumpy[right] == 1 ? customers[right] : 0;
        }
        int maxSatisfied = currSatisfied;
        currSatisfied -= grumpy[left] == 0 ? 0 : customers[left];
        left++;
        satisfiedSum += grumpy[right] == 0 ? customers[right] : 0;
        right++;
        while (right < n) {
            currSatisfied += grumpy[right] == 1 ? customers[right] : 0;
            maxSatisfied = Math.max(maxSatisfied, currSatisfied);
            currSatisfied -= grumpy[left] == 0 ? 0 : customers[left];
            left++;
            satisfiedSum += grumpy[right] == 0 ? customers[right] : 0;
            right++;
        }
        System.out.println(satisfiedSum + maxSatisfied);
        return satisfiedSum + maxSatisfied;
    }

    public static void main(String[] args) {
        LeeCode1052 leeCode1052 = new LeeCode1052();
        leeCode1052.maxSatisfied(new int[]{9,10,4,5},
                                 new int[]{1,0,1,1}, 1);

    }
}
