package com.com.code2021.july.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description:
 * 题目描述
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 20:00:54	  heyile h00451788 : 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author: zhongmou.ji
 * @create: 2021/7/5 下午7:24
 **/
public class Main {

  public static final Map<Integer, char[]> numCharacterMap = new HashMap<Integer, char[]>(){
    {
      put(2, new char[]{'a', 'b', 'c'});
      put(3, new char[]{'d', 'e', 'f'});
      put(4, new char[]{'g', 'h', 'i'});
      put(5, new char[]{'j', 'k', 'l'});
      put(6, new char[]{'m', 'n', 'o'});
      put(7, new char[]{'p', 'q', 'r', 's'});
      put(8, new char[]{'t', 'u', 'v'});
      put(9, new char[]{'w', 'x', 'y', 'z'});
    }
  };

  /**
   * 根据输入字符串， 返回所有它能表示的字母组合。
   * @param s 字符串
   * @return 字母组合
   */
  public List<String> getCombineCharacterList(String s) {
    List<String> res = new ArrayList<>();
    backtrack(res, s, new StringBuilder(), 0, s.length());
    return res;
  }

  /**
   * 回溯
   * @param res 返回的结果集
   * @param s 输入字符串
   * @param sb 当前拼接的字符串
   * @param index 当前下标
   * @param length 字符串长度
   */
  private void backtrack(List<String> res, String s, StringBuilder sb, int index, int length) {
    if (index == length) {
      res.add(sb.toString());
      return;
    }
    char[] chars = numCharacterMap.get(s.charAt(index) - '0');
    for (int i = 0; i < chars.length; i++) {
      sb.append(chars[i]);
      backtrack(res, s, sb, index + 1, length);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.getCombineCharacterList("33");
  }


}
