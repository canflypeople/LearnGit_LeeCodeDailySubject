package com.com.code2021.january;

import java.util.HashSet;
import java.util.Set;

/**
 * @program:
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * @author: zhongmou.ji
 * @create: 2021/2/1 上午8:50
 **/
public class LeeCode888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            sumA += num;
            set.add(num);
        }
        for (int num : B) {
            sumB += num;
        }
        int diff = (sumA - sumB) / 2; // B需要多加这么多才可以变为half
        for (int num : B) {
            if (set.contains(diff + num)) {
                return new int[]{diff + num, num};
            }
        }
        return new int[]{};
    }
}
