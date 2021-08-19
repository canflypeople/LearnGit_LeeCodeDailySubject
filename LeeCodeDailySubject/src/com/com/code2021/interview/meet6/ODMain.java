package com.com.code2021.interview.meet6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/6/25 下午3:57
 **/
public class ODMain {

  public static void main() {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      String out = in.nextLine();
      String[] arr = out.split(",");
      Arrays.sort(arr);
      StringBuilder sb = new StringBuilder();
      for (String str : arr) {
        sb.append(str + ",");
      }
      System.out.println(sb.substring(0, sb.length() - 1));
    }
  }

//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String input = null;
//    while ((input = br.readLine()) != null) {
//      int sum = 0;
//      String[] s = input.split(" ");
//      for (int i = 0; i < s.length; i++) {
//        sum += Integer.parseInt(s[i]);
//      }
//      System.out.println(sum);
//    }
//  }

//  public void inout() {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int i = br.readLine();
//
//  }
}
