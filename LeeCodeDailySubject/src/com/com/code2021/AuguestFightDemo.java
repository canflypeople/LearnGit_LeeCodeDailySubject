package com.com.code2021;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/8/2 上午9:17
 **/
public class AuguestFightDemo {

  /**
   * 743. 网络延迟时间
   * 有 n 个网络节点，标记为 1 到 n。
   *
   * 给你一个列表 times，表示信号经过 有向 边的传递时间。
   * times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
   *
   * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
   *
   *
   *
   * 示例 1：
   *
   *
   *
   * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
   * 输出：2
   * @param times
   * @param n
   * @param k
   * @return
   */
  public int networkDelayTime(int[][] times, int n, int k) {
    /**
     * 有向带权图
     */
    // 1. 构建图
    // 2. 从规定顶点开始 广度优先遍历
    // 3. 记录每个顶点最短路径，遍历并进行更新
    List<int[]>[] edges = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      edges[i] = new ArrayList<>();
    }
    for (int[] time : times) {
      edges[time[0]].add(new int[]{time[1], time[2]});
    }
    int[] visited = new int[n + 1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(k);
    while (!queue.isEmpty()) {
      int node = queue.poll();

    }
    return -1;
  }

  public static void main(String[] args) {
    File file = new File("test1/test1");
    if (!file.exists()) {
      System.out.println(file.mkdir());
    }
  }
}
