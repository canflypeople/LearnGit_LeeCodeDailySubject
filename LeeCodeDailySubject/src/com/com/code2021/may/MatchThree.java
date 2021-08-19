package com.com.code2021.may;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/23 上午10:32
 **/
public class MatchThree {


  /**
   * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，
   * 返回 true ；否则，返回 false 。
   * @param s
   * @return
   */
  public boolean checkZeroOnes(String s) {
    int oneMaxLen = 0, zeroMaxLen = 0;
    int oneCurrLen = 0, zeroCurrLen = 0;
    char pre = '2';
    for (char c : s.toCharArray()){
      if (pre == '0') {
        if (c == '0') {
          zeroCurrLen++;
        } else if (c == '1') {
          zeroMaxLen = Math.max(zeroCurrLen, zeroMaxLen);
          zeroCurrLen = 0;
          oneCurrLen++;
        }
      } else if (pre == '1') {
        if (c == '0') {
          oneMaxLen = Math.max(oneMaxLen, oneCurrLen);
          oneCurrLen = 0;
          zeroCurrLen++;
        } else if (c == '1') {
          oneCurrLen++;
        }
      } else {
        if (c == '0') {
          zeroCurrLen++;
        } else if (c == '1') {
          oneCurrLen++;
        }
      }
      pre = c;
    }
    oneMaxLen = Math.max(oneMaxLen, oneCurrLen);
    zeroMaxLen = Math.max(zeroCurrLen, zeroMaxLen);
    System.out.println(oneMaxLen > zeroMaxLen);
    return oneMaxLen > zeroMaxLen;
  }


  /**
   * 二分法
   * @param dist
   * @param hour
   * @return
   */
  public int minSpeedOnTime(int[] dist, double hour) {
    int n = dist.length;
    int res = -1;
    if (n - 1 > hour) {
      return res;
    }
    int maxSpeed = 0;
    for (int len : dist) {
      maxSpeed = Math.max(len, maxSpeed);
    }
    maxSpeed = Math.max(maxSpeed, (int) Math.ceil(dist[n - 1] / (hour - (int)hour)));
    int left = 0, right = maxSpeed;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      double cost = 0;
      for (int i = 0; i < n - 1; i++) {
        cost += (int) Math.ceil((double) dist[i] / mid);
      }
      cost += (double) dist[n - 1] / mid;
      if (cost > hour) {
        left = mid + 1;
      } else if (cost < hour) {
        right = mid - 1;
        res = mid;
      } else if (cost == hour) {
        return mid;
      }
    }
    return res;
  }


  /**
   * 动态规划， 记忆搜索
   * @param s
   * @param minJump
   * @param maxJump
   * @return
   */
  public boolean canReach(String s, int minJump, int maxJump) {
    char[] chArr = s.toCharArray();
    int n = chArr.length;
    boolean[] visits = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    while (!queue.isEmpty()) {
      int index = queue.poll();
      int maxDistance = Math.min(n - 1, maxJump + index);
      for (int i = index + minJump; i <= maxDistance; i++) {
        if (chArr[i] == '0' && visits[i] == false) {
          queue.offer(i);
          visits[i] = true;
          if (i == n - 1) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    MatchThree three = new MatchThree();
    three.canReach("01101110", 2, 3);
//    three.minSpeedOnTime(new int[]{1, 1, 10000}, 2.01);
//    three.checkZeroOnes("1101");
  }
}
