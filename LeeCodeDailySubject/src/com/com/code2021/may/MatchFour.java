package com.com.code2021.may;

import java.util.PriorityQueue;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/30 上午10:34
 **/
public class MatchFour {

  public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    return getNum(firstWord) + getNum(secondWord) == getNum(targetWord);
  }

  public int getNum(String word) {
    int num = 0;
    int index = 0;
    int n = word.length();
    while (index < n) {
      num = num * 10 + (word.charAt(index) - 'a');
      index++;
    }
    return num;
  }

  public String maxValue(String n, int x) {
    int index = 0;
    int len = n.length();
    boolean isPositive = n.charAt(0) != '-' ? true : false;
    while (index < len) {
      if (isPositive) {
        if (n.charAt(index) - '0' < x) {
          break;
        } else if (n.charAt(index) - '0' == x) {
          index++;
        } else if (n.charAt(index) - '0' > x) {
          index++;
        }
      } else {
        if (n.charAt(index) - '0' > x) {
          break;
        } else if (n.charAt(index) - '0' == x) {
          index++;
        } else if (n.charAt(index) - '0' < x) {
          index++;
        }
      }
    }
    return n.substring(0, index) + x + n.substring(index, len);
  }


  public int[] assignTasks(int[] servers, int[] tasks) {
    int taskLen = tasks.length;
    int[] res = new int[taskLen];
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    // 维护剩余的机器， 当机器用完还需要放回池子中
    return null;
    //

  }


}
