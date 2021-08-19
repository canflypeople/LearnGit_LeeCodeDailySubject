package com;



// time java SafepointTestp
// 你还可以使用如下几个选项
// -XX:+PrintGC
// -XX:+PrintGCApplicationStoppedTime
// -XX:+PrintSafepointStatistics
// -XX:+UseCountedLoopSafepoints
public class Main {
  static double sum = 0;

  public static void foo() {
    for (int i = 0; i < 0x77777777; i++) {
      sum += Math.sqrt(i);
    }
  }

  public static void bar() {
    for (int i = 0; i < 50_000_000; i++) {
      new Object().hashCode();
    }
  }

  public static void main(String[] args) {
//    new Thread(Main::foo).start();
//    new Thread(Main::bar).start();

    String emailStr = new String("zhongmou.ji@aispeech.com,xuehui.ren@aispeech.com,xiang.gao@aispeech.com,xin.fang@aispeech.com,RD.engineer.list@aispeech.com,Architect.list@aispeech.com,xiaoshuang.wang@aispeech.com,kai.yu@aispeech.com,bo.li@aispeech.com,kan.yao@aispeech.com,xinyu.lu@aispeech.com,zhen.liu@aispeech.com,dazhu.zhang@aispeech.com,xin.xie@aispeech.com,ross.zhu@aispeech.com,yijun.zhu@aispeech.com,lili.jin@aispeech.com,zuolin.xu@aispeech.com");
    String[] emailArray = emailStr.split(",");
    StringBuilder sb = new StringBuilder();
    for (String email : emailArray) {
      System.out.println(email);
      sb.append(emailStr + ",");
    }
    System.out.println(sb.substring(0, sb.length() - 1));
  }
}