package com.code2020.January;

/**
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 */
public class LeeCode205 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int index = 0;
        int length = flowerbed.length;
        if (length < 2) {
            return flowerbed[0] == 1 ? n == 0 : n == 1;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            count++;
            index = 1;
        }
        while (index < length) {
            while (index < length && flowerbed[index] == 1) {
                index++;
            }
            int rest = 0;
            while (index < length && flowerbed[index] == 0) {
                index++;
                rest++;
            }
            if (index == length) {
                rest++;
            }
            index++;
            System.out.println("0的长度" + rest);
            if (rest < 3) {
                continue;
            }
            count = rest > 2 ? (rest - 1) / 2 : 0;

        }
        return n <= count;

    }

    public static void main(String[] args) {
        LeeCode205 leeCode205 = new LeeCode205();
        System.out.println(leeCode205.canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2));
    }


}
