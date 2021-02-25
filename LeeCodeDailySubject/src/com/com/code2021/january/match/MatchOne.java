package com.com.code2021.january.match;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/1/31 上午10:44
 **/
public class MatchOne {

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int bucket = getNumSum(i);
            map.put(bucket, map.getOrDefault(bucket, 0) + 1);
        }
        int res = 0;
        for (int sum : map.values()) {
            res = Math.max(sum, res);
        }
        return res;

    }

    public int getNumSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        System.out.println(sum);
        return sum;
    }

    /**
     * 无向图
     * @param adjacentPairs
     * @return
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            int x = adjacentPair[0], y = adjacentPair[1];
            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<Integer>(2));
            }
            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<Integer>(2));
            }
            map.get(x).add(y);
            map.get(y).add(x);
        }
        List<Integer> ans = new ArrayList<>();
        int currNUm = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                int key = entry.getKey(), value = entry.getValue().get(0);
                ans.add(key);
                ans.add(value);
                currNUm = value;
                break;
            }
        }
        while (true) {
            if (map.get(currNUm).size() == 1) {
                break;
            }
            System.out.println(-66119 != -66119);
            System.out.println(map.get(currNUm).get(0) + "....." + ans.get(ans.size() - 2) + String.valueOf(map.get(currNUm).get(0) != ans.get(ans.size() - 2)));
            if (map.get(currNUm).get(0) != ans.get(ans.size() - 2)) {
                ans.add(map.get(currNUm).get(0));
            } else {
                ans.add(map.get(currNUm).get(1));
            }
            currNUm = ans.get(ans.size() - 1);
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size() - 1; i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    /**
     * 模拟
     * @param candiesCount
     * @param queries
     * @return
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        return null;
    }

    public static void main(String[] args) {
        MatchOne matchOne = new MatchOne();
        //matchOne.countBalls(1, 21);
        matchOne.restoreArray(new int[][]{{91207,59631},{581,91207},{51465,20358},{-66119,94118},{-7392,72809},{51465,-7392},{-98504,-29411},{-98504,35968},{35968,59631},{94118,20358},{72809,581},{34348,43653},{43653,-29411}});
    }
}
