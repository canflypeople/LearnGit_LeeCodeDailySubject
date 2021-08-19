package com.com.code2021.com.code2021.march;


import java.util.*;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/3/20 下午10:23
 **/
public class LeeCode150 {

    Set<String> set = new HashSet<String>(Arrays.asList(new String[]{"+", "-", "*", "/"}));

//    public int evalRPN(String[] tokens) {
//        Character.is
//        // 入栈
//        // 出栈
//        Stack<Integer> stack = new Stack<>();
//        for (String s : tokens) {
//            if (set.contains(new Character(s))) {
//                stack.push(s);
//            } else {
//                stack.push(Integer.parseInt(s));
//            }
//        }
//
//    }


    public int secondHighest(String s) {
        int[] arr = new int[2];
        Arrays.fill(arr, -1);
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > arr[0]) {
                    arr[1] = arr[0];
                    arr[0] = num;
                } else if (num != arr[0] && num > arr[1]) {
                    arr[1] = num;
                }
            }
        }
        return arr[1];

    }

//    public int getMaximumConsecutive(int[] coins) {
//        Set<Integer> set = new HashSet<>();
//        Arrays.sort(coins);
//        set.add(0);
//        for (int num : coins) {
//            if (set.contains(num - 1)) {
//                set.add()
//            }
//        }
//
//    }

    /*
    orders[i] = [pricei, amounti, orderTypei] 0 bug 1 sell
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        long res = 0;
        PriorityQueue<long[]> buyQueue = new PriorityQueue<long[]>((o1, o2) ->  o1[0] <= o2[0] ? 1 : -1);
        PriorityQueue<long[]> sellQueue = new PriorityQueue<long[]>((o1, o2) ->  o1[0] >= o2[0] ? 1 : -1);
        for (int[] order : orders) {
            if (order[2] == 0) {// bug
                Iterator<long[]> iterator = sellQueue.iterator();
                while (iterator.hasNext()) {
                    long[] curr = iterator.next();
                    if (order[0] < curr[0]) {
                        buyQueue.offer(new long[]{order[0], order[1]});
                    } else if (order[1] > 0) {
                        if (order[1] >= curr[1]) {
                            iterator.remove();
                            order[1] -= curr[1];
                            if (order[1] > 0) {
                                buyQueue.offer(new long[]{order[0], order[1]});
                            }
                        } else if (order[1] < curr[1]) {
                            curr[1] -= order[1];
                            order[1] = 0;
                            break;
                        }
                    } else break;
                }
            } else if (order[2] == 1) {// sell
                Iterator<long[]> iterator = buyQueue.iterator();
                while (iterator.hasNext()) {
                    long[] curr = iterator.next();
                    if (order[0] > curr[0]) {
                        sellQueue.offer(new long[]{order[0], order[1]});
                    } else if (order[1] > 0) {
                        if (order[1] >= curr[1]) {
                            iterator.remove();
                            order[1] -= curr[1];
                        } else if (order[1] < curr[1]) {
                            curr[1] -= order[1];
                            order[1] = 0;
                            if (order[1] > 0) {
                                sellQueue.offer(new long[]{order[0], order[1]});
                            }
                            break;
                        }
                    } else break;
                }
            }
        }
        for (long[] buy : buyQueue) {
            res += buy[1];
        }
        for (long[] sell : sellQueue) {
            res += sell[1];
        }
        return (int) (res % (((int) Math.pow(10, 9)) + 7));
    }

    public static void main(String[] args) {
        LeeCode150 leeCode150 = new LeeCode150();
//        leeCode150.getNumberOfBacklogOrders(
//                new int[][]{new int[]{7,1000000000,1}, new int[]{15,3,0}, new int[]{5,999999995,0},new int[]{5,1,1}});
        leeCode150.getNumberOfBacklogOrders(
                new int[][]{new int[]{10,5,0},new int[]{15,2,1}, new int[]{25,1,1}, new int[]{30,4,0}});
        leeCode150.secondHighest("sjhtz8344");
    }
}
