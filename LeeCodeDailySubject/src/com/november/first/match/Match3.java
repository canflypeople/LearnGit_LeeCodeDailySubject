package com.november.first.match;

import java.util.Arrays;

public class Match3 {

    public int maxProfit(int[] inventory, int orders) {
        long pay = 0;
        Arrays.sort(inventory);
        int count = 0;
        int i = inventory.length - 1;
        while (orders > 0) {
            int temp = i;
            count++;
            while (i - 1 >= 0 && inventory[i] == inventory[i - 1]) {
                count++;
                i--;
            }
            int down = i > 0 ? inventory[i - 1]: 0;
            for (int p = inventory[temp]; p > down; p--) {
                if (orders > count) {
                    pay += count * p;
                    orders -= count;
                } else {
                    pay += orders * p;
                    orders = 0;
                    break;
                }
            }
            i--;

        }
        return (int) (pay % (Math.pow(10, 9) + 7));

    }

    public static void main(String[] args) {
        Match3 match3 = new Match3();
        System.out.println(match3.maxProfit(new int[]{773160767},
        252264991));
    }

}