package com.com.code2021.may;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/15 上午9:44
 **/
public class LeetCode13 {
  public final Map<Character, Integer> map = new HashMap<>();
  public LeetCode13() {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
  }

  public int romanToInt(String s) {
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    int res = 0;
    res += map.get(s.charAt(0));
    for (int i = 1; i < n; i++) {
      res += map.get(s.charAt(i));
      if (map.get(s.charAt(i - 1)) < map.get(s.charAt(i))) {
         res -= 2 * map.get(s.charAt(i - 1));
      }
    }
    return res;

  }
}
