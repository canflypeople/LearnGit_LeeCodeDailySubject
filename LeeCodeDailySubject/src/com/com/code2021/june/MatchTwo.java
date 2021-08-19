package com.com.code2021.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/6/12 下午10:32
 **/
public class MatchTwo {

  /**
   * 5767. 检查是否区域内所有整数都被覆盖 显示英文描述
   * 通过的用户数0
   * 尝试过的用户数0
   * 用户总通过次数0
   * 用户总提交次数0
   * 题目难度Easy
   * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
   *
   * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
   *
   * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
   * @param ranges
   * @param left
   * @param right
   * @return
   */
  public boolean isCovered(int[][] ranges, int left, int right) {
    // 贪心
    Arrays.sort(ranges, ((o1, o2) -> {
      return o1[0]== o2[0] ? (o1[1] > o2[1] ? 1 : -1) : (o1[0] - o2[0]);
    }));
    int preLeft = ranges[0][0], preRight = ranges[0][1];
    int n = ranges.length;
    List<int[]> list = new ArrayList<>();
    list.add(new int[]{ranges[0][0], ranges[0][1]});
    for (int i = 1; i < n; i++) {
      if (preLeft <= ranges[i][0] && ranges[i][1] <= preRight) {
        continue;
      } else if ((ranges[i][0] >= preLeft && ranges[i][0] <= preRight) || ranges[i][0] == preRight + 1) {
        list.remove(list.size() - 1);
        list.add(new int[]{preLeft, ranges[i][1]});
      } else {
        list.add(new int[]{ranges[i][0], ranges[i][1]});
        preLeft = ranges[i][0];
      }
      preRight = ranges[i][1];
    }
    for (int[] range : list) {
      if (range[0] <= left && right <= range[1]) {
        return true;
      } else if (range[0] <= left && right > range[1]) {
        return false;
      }
    }
    System.out.println("xxxx");
    return false;

  }


  /**
   * 5768. 找到需要补充粉笔的学生编号 显示英文描述
   * 通过的用户数1434
   * 尝试过的用户数1558
   * 用户总通过次数1444
   * 用户总提交次数3506
   * 题目难度Medium
   * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
   *
   * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
   *
   * 请你返回需要 补充 粉笔的学生 编号 。
   * @param chalk
   * @param k
   * @return
   */
  public int chalkReplacer(int[] chalk, int k) {
    // 模拟
    long n = chalk.length;
    long sum = 0;
    for (int cost : chalk) {
      sum += cost;
    }
    long count = k / sum * n;
    long rest = k % sum;
    int index = 0;
    while (rest > chalk[index]) {
      rest -= chalk[index];
      index++;
    }
    return (int) ((count + index) % n);

  }

  public static void main(String[] args) {
    MatchTwo matchTwo = new MatchTwo();
    matchTwo.chalkReplacer(new int[]{3, 4, 1, 2}, 25);
//    matchTwo.chalkReplacer(new int[]{5, 1, 5}, 22);
//    matchTwo.isCovered(new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6}}, 2, 5);
//    matchTwo.isCovered(new int[][]{new int[]{25,42}, new int[]{7,14}, new int[]{2,32}, new int[]{25,28}, new int[]{39,49}, new int[]{1,50}, new int[]{29,45}, new int[]{18,47}}, 15, 38);
  }
}
