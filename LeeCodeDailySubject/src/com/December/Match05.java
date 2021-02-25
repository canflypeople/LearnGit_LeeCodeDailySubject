package com.December;

import java.util.*;

public class Match05 {

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String str1 = s.substring(0, n / 2);
        String str2 = s.substring(n / 2, n);
        Set<Character> set = new HashSet<Character>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
        int count = 0;
        for (char c : str1.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        for (char c : str2.toCharArray()) {
            if (set.contains(c)) {
                count--;
            }
        }
        return count == 0 ? true : false;
    }

    /**
     * 贪心+优先队列：每次都吃要最先过期的苹果
     * 队列，过期时间最早的在队列的最前面
     * 入队，一个是过期时间，过期时间为当前时间加过期时间，值为苹果的个数
     * 出对，过期的苹果直接出队
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        if (apples.length == 0) {
            return 0;
        }
        int ret = 0;
        Queue<int[]> priorityQueue = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
        int n = apples.length;
        int currDay = 0;
        while (!priorityQueue.isEmpty() || currDay < n) {
            if (currDay < n) {
                if (apples[currDay] > 0) {
                    priorityQueue.offer(new int[]{currDay + days[currDay] - 1, apples[currDay]});
                }
            }
            // 吃一个苹果
            if (!priorityQueue.isEmpty()) {
                int[] arr = priorityQueue.peek();
                arr[1]--;
                if (arr[1] == 0) {
                    priorityQueue.poll();
                }
                ret++;
            }
            currDay++;
            // 将坏苹果出队
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] < currDay) {
                priorityQueue.poll();
            }
        }
        return ret;
    }

    /**
     * 模拟
     * @param grid
     * @return
     */
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ret[] = new int[n];
        Arrays.fill(ret, -2);
        for (int temp = 0; temp < n; temp++) {
            int i = 0, j = temp;
            while (i < m) {
                if ((j == 0 && grid[i][j] == -1)
                        || (j == n - 1 && grid[i][j] == 1)
                        || (grid[i][j] == 1 && grid[i][j + 1] == -1)
                        || (grid[i][j] == -1 && grid[i][j - 1] == 1)) {
                    ret[temp] = -1;
                    break;
                }
                if (grid[i][j] == 1) {
                    i++;
                    j++;
                } else if (grid[i][j] == -1) {
                    i++;
                    j--;
                }
            }
            if (i == m && ret[temp] == -2) {
                ret[temp] = j;
            }
        }
        return ret;

    }

    public void test1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        Match05 match05 = new Match05();
        match05.test1();
        System.out.println(match05.findBall(new int[][]{new int[]{1,1,1,-1,-1},new int[]{1,1,1,-1,-1},new int[]{-1,-1,-1,1,1},new int[]{1,1,1,1,-1},new int[]{-1,-1,-1,-1,-1}}));
        match05.eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2});
    }
}
