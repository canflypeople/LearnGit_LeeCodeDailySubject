package com.com.code2021.com.code2021.march;

import java.util.*;

/**
 * @program:
 * @description:
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * @author: zhongmou.ji
 * @create: 2021/3/6 下午3:25
 **/
public class LeeCode503 {
    /**
     * 单调栈， 递减的栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        // 栈中存入数组的下标
        // 若栈顶的所在的数 小于 当前数， 则出栈并设置 pop所在的值为当前值
        // 将当前下标入栈
        // 因为是循环数组， 所以需遍历两次
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i % n]) {
                ret[deque.pop()] = nums[i % n];
            }
            deque.push(i % n);
        }
        return ret;

    }


    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                if (getDistance(x, y, points[i][0], points[i][1]) < minDistance) {
                    index = i;
                    minDistance= getDistance(x, y, points[i][0], points[i][1]);
                }
            }
        }
        return index;
    }

    private int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public boolean checkPowersOfThree(int n) {
        int preValue = getMi(n);
        n -= preValue;
        while (n > 0) {
            int mutl = getMi(n);
            if (preValue == mutl) {
                return false;
            }
            preValue = mutl;
            n -= mutl;
        }
        return true;

    }

    private int getMi(int n) {
        int left = 0, right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int value = (int) Math.pow(3, mid);
            if (value < n) {
                if (value * 3 > n) {
                    return value;
                } else if (value * 3 == n) {
                    return value * 3;
                }
                left = mid + 1;
            } else if (value > n) {
                if (value / 3 <= n) {
                    return value / 3;
                }
                right = mid - 1;
            } else if (value == n) {
                return value;
            }
        }
        return (int) Math.pow(3, left);
    }


    Map<Integer, Integer>[] maps;

    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>(26);
        maps = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i) - 'a', map.getOrDefault(s.charAt(i) - 'a', 0) + 1);
            maps[i] = new TreeMap<>(map);
        }
        for (int len = 2; len <= n; len++) {
            for (int i = len - 1; i < n; i++) {
                if (len == 4 && i == 4) {
                    int y = 1;
                }
                int value = getBeauty(s, i - len, i);
                if (value != 0) {
                    System.out.println(value);
                    System.out.println(s.substring(i - len == -1 ? 0 : i - len + 1, i + 1));
                    System.out.println();
                }
                ans += getBeauty(s, i - len, i);
            }
        }
        return ans;
    }

    private int getBeauty(String s, int beginIndex, int endIndex) {
        Map<Integer, Integer> map;
        if (beginIndex == -1) {
            map = maps[endIndex];
        } else {
            Map<Integer, Integer> preMap = maps[beginIndex];
            Map<Integer, Integer> afterMap = maps[endIndex];
            map = new HashMap<>();
            for (int i : afterMap.keySet()) {
                int count = afterMap.get(i) - preMap.getOrDefault(i, 0);
                if (count != 0) {
                    map.put(i, count);
                }
            }
        }
        int minCount = Integer.MAX_VALUE, maxCount = Integer.MIN_VALUE;
        for (int value : map.values()) {
            minCount = Math.min(value, minCount);
            maxCount = Math.min(value, maxCount);
        }
        return maxCount == minCount ? 0 : maxCount - minCount;
    }

    public int minElements(int[] nums, int limit, int goal) {
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double target = Math.abs(goal - sum);
        return (int) Math.ceil(target / limit);
    }

    /**
     * 最短路径，然后无向图
     * @param n
     * @param edges
     * @return
     */
    public int countRestrictedPaths(int n, int[][] edges) {
        // 构建图
        List<int[]>[] list = new List[n];
        Arrays.fill(list, new ArrayList<int[]>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], score = edge[2];
            list[x].add(new int[]{y, score});
            list[y].add(new int[]{x, score});
        }
        // bfs：求最短路径
        int[] minRoads = new int[n];
        for (int i = n - 2; i < n - 1; i++) {
            Queue<Integer> queue = new LinkedList<>();
        }
        return 1;

    }


//    public void bfs(int s, int t) {
//        if (s == t) return;
//        boolean[] visited = new boolean[v];
//        visited[s]=true;
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(s);
//        int[] prev = new int[v];
//        for (int i = 0; i < v; ++i) {
//            prev[i] = -1;
//        }
//        while (queue.size() != 0) {
//            int w = queue.poll();
//            for (int i = 0; i < adj[w].size(); ++i) {
//                int q = adj[w].get(i);
//                if (!visited[q]) {
//                    prev[q] = w;
//                    if (q == t) {
//                        print(prev, s, t);
//                        return;
//                    }
//                    visited[q] = true;
//                    queue.add(q);
//                }
//            }
//        }
//    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(3, -2));
        LeeCode503 leeCode503 = new LeeCode503();
        leeCode503.beautySum("aabcb");
        leeCode503.checkPowersOfThree(27);
    }
}
