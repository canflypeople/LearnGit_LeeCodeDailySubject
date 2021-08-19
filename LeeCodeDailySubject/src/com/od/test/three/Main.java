package com.od.test.three;


import java.util.*;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/6/27 下午7:03
 **/
public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String dependentString = in.nextLine();
    String breakdownString = in.nextLine();
    String[] dependentArr = dependentString.split(",");
    String[] breakdownServices = breakdownString.split(",");
    // 被关联映射， key 被依赖的服务器， value，依赖该服务的服务列表
    Map<String, Set<String>> dependenceMap = new HashMap<>();
    Set<String> orderServices = new LinkedHashSet<>();
    for (String str : dependentArr) {
      String[] dependence = str.split("-");
      String service = dependence[0], dependentService = dependence[1];
      if (!orderServices.contains(service)) {
        orderServices.add(service);
        dependenceMap.put(service, new HashSet<>());
      }
      if (!orderServices.contains(dependentService)) {
        orderServices.add(dependentService);
        dependenceMap.put(dependentService, new HashSet<>());
      }
      dependenceMap.get(dependentService).add(service);
    }
    for (String breakdownService : breakdownServices) {
      Queue<String> breakdownQueue = new LinkedList<>();
      breakdownQueue.add(breakdownService);
      while (!breakdownQueue.isEmpty()) {
        String tempService = breakdownQueue.poll();
        if (orderServices.contains(tempService)) {
          orderServices.remove(tempService);
          for (String influencedService : dependenceMap.get(tempService)) {
            breakdownQueue.offer(influencedService);
          }
        }
      }
    }
    if (orderServices.isEmpty()) {
      System.out.println(",");
    } else {
      StringBuilder sb = new StringBuilder();
      for (String normalService : orderServices) {
        sb.append(normalService + ",");
      }
      System.out.println(sb.substring(0, sb.length() - 1).toString());
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
