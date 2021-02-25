package com.code2020.January;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program:
 * @description:
 * 724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * @author: zhongmou.ji
 * @create: 2021/1/28 上午9:13
 **/
public class LeeCode724 {

    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        int[] preSums = getPreSum(nums);
        if (preSums[n - 1] - preSums[0] == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            if (preSums[i - 1] == preSums[n - 1] - preSums[i]) {
                return i;
            }
        }
        return -1;


    }

    private int[] getPreSum(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] preSums = new int[n];
        preSums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSums[i] += preSums[i - 1] + nums[i];
        }
        return preSums;
    }

    public static void main(String[] args) {
        List<Temp> list = new ArrayList<Temp>();
        list.add(new Temp(1));
        list.add(new Temp(2));
        list.add(new Temp(3));
        list.add(new Temp(4));
        list.stream().forEach(new Consumer<Temp>() {
            @Override
            public void accept(Temp temp) {
                temp.value++;
            }
        });
        for (Temp temp : list) {
            System.out.println(temp.value);
        }
    }

    static class Temp {
        int value;
        public Temp(int value) {
            this.value = value;
        }
    }
}
