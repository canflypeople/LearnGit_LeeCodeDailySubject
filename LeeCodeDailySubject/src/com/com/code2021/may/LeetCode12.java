package com.com.code2021.may;

/**
 * @program:
 * @description:
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内
 * @author: zhongmou.ji
 * @create: 2021/5/14 上午9:16
 **/
public class LeetCode12 {


  /**
   * 58
   * 输出：
   * "CIII"
   * 预期结果：
   * "LVIII"
   * @param num
   * @return
   */
  public String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();
    if (num / 1000 > 0) {
      int count = num / 1000;
      switch (count) {
        case 1 : sb.append("M"); break;
        case 2 : sb.append("MM"); break;
        case 3 : sb.append("MMM"); break;
        default: break;
      }
      num -= 1000 * count;
    }
    if (num / 100 > 0) {
      int count = num / 100;
      if (count == 4) {
        sb.append("CD");
      } else if (count == 9) {
        sb.append("CM");
      } else {
        String str = count >= 5 ? "D" : "";
        sb.append(str);
        int len = count >= 5 ? count - 5 : count;
        for (int i = 0; i < len; i++) {
          sb.append("C");
        }
      }
      num -= 100 * count;
    }

    if (num / 10 > 0) {
      int count = num / 10;
      if (count == 4) {
        sb.append("XL");
      } else if (count == 9) {
        sb.append("XC");
      } else {
        String str = count >= 5 ? "L" : "";
        sb.append(str);
        int len = count >= 5 ? count - 5 : count;
        for (int i = 0; i < len; i++) {
          sb.append("X");
        }
      }
      num -= 10 * count;
    }
    if (num > 0) {
      int count = num;
      if (count == 4) {
        sb.append("IV");
      } else if (count == 9) {
        sb.append("IX");
      } else {
        String str = count >= 5 ? "V" : "";
        sb.append(str);
        int len = count >= 5 ? count - 5 : count;
        for (int i = 0; i < len; i++) {
          sb.append("I");
        }
      }
      num -= 10 * count;
    }
    return sb.toString();


  }
}
