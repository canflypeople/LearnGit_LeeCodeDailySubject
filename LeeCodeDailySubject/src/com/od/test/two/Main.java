package com.od.test.two;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/6/27 下午7:03
 **/
public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int sum, n;
    while (in.hasNextInt()) {
      sum = in.nextInt();
      n = in.nextInt();
      int afterDiffSum = 0;
      for (int i = 0; i < n; i++) {
        afterDiffSum += i;
      }
      int beginNum = (sum - afterDiffSum) / n;
      for (int i = 0; i < n - 1; i++) {
        System.out.print(beginNum + i);
        System.out.println(" ");
      }
      System.out.println(beginNum + n - 1);
    }

  }

  public static void main1(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
      int a = in.nextInt();
      int b = in.nextInt();
      System.out.println(a + b);
    }
  }


  public static void main2(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int ans = 0, x;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        x = sc.nextInt();
        ans += x;
      }
    }
    System.out.println(ans);
  }
}
