package com.od.test;


import java.util.*;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/6/27 下午7:03
 **/
public class Main {

  /**
   * 模拟复制粘贴, 输入一个 整数数组, 数组元素在1-5之间
   * 1 输入, a 在文本上输入a
   * 2 复制, ctrl + c 复制所选的元素到复制板中
   * 3 剪切: ctrl + x 复制所选的元素到复制板中, 将当前文本内容清空
   * 4 粘贴: ctrl + v 将复制板中的元素粘贴至文本中
   * 5 选择: ctrl + a 将文本内容全选中
   * 输出执行操作后文本中的内容
   */
  public static void questionOne() {
    Scanner in = new Scanner(System.in);
    List<Integer> commands = new ArrayList<>();
    while (in.hasNextInt()) {
      commands.add(in.nextInt());
    }
    char element = 'a';
    StringBuilder content = new StringBuilder();
    boolean isSelected = false;
    String copyContent = "";

    // 没有元素： content.length() == 0
    // 没有选择： selectFlag != true
    // 选择的内容： selectContent = "xefdsafd"
    // ! 拷贝不会撤销全选状态
    for (int command : commands) {
      switch (command) {
        case 1: // 输入a
          if (isSelected == true) {
            content = new StringBuilder();
            isSelected = false;
          }
          content.append(element);
          break;
        case 2: // 复制
          if (isSelected == true) {
            copyContent = content.toString();
          }
          break;
        case 3: // 剪切
          if (isSelected == true) {
            copyContent = content.toString();
            content = new StringBuilder();
          }
          break;
        case 4: // 粘贴
          if (isSelected == true) {
            content = new StringBuilder();
            isSelected = false;
          }
          content.append(copyContent);
          break;
        case 5: // 选择全部
          if (content.length() != 0) {
            isSelected = true;
          } else {
            isSelected = false;
          }
        default:
          break;
      }
    }
    System.out.println(content.length());
  }

  /**
   * 输入两个数, 第一个是指定的和sum, 第二个是元素的个数n
   * 输出是否存在n个连续的正整数(如1, 2, 3, 4), 其和等于sum
   *
   * 要求： 给定sum和n， 输出符合条件的起始num集合
   */
  public static void questionTwo() {
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

  /**
   * 给定一个服务器依赖列表字符串， 如 A-B, B-C 则表示A依赖于B, B依赖于C
   * 再给定一个服务器故障的列表， 如A,B,C 则表示A、B、C故障
   * 如果A依赖于B，服务B依赖于服务C，且C发生了故障，那么服务B和服务A也被认定为不可用
   *
   * 要求： 给定服务依赖列表、服务故障列表， 按顺序输出可用服务的列表
   */
  public static void questionThree() {
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
      return;
    } else {
      System.out.println(String.join(",", orderServices));
    }
  }

  public static int getMaxMultiValue(int[] nums) {
    if (nums.length < 3) {
      return -1;
    }
    // 乘积最大， 3个数
    Arrays.sort(nums);
    int positiveNumberCount = 0;
    int negativeNumberCount = 0;
    boolean isExistZero = false;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] < 0) {
        negativeNumberCount++;
      } else if (nums[i] > 0) {
        positiveNumberCount++;
      } else if (nums[i] == 0) {
        isExistZero = true;
      }
    }
    if (positiveNumberCount == 0) {
      if (isExistZero) {
        return 0;
      }
      return 1;
    }
    return 1;
//    Arrays.sort(nums);
//    int n = nums.length;
//    if (nums[n - 1] > 0) {
//
//    }
//
//    int max1=Integer.MIN_VALUE;
//    int max2=Integer.MIN_VALUE;
//    int max3=Integer.MIN_VALUE;
//    int min1=Integer.MAX_VALUE;
//    int min2=Integer.MAX_VALUE;
//
//    int output=0;
//
//    for (int i=0;i<nums.length;i++) {
//      if (nums[i]>max1) {
//        max3=max2;
//        max2=max1;
//        max1=nums[i];
//      } else if (nums[i]>max2) {
//        max3=max2;
//        max2=nums[i];
//      } else if (nums[i]>max3) max3=nums[i];
//
//      if (nums[i]<min1) {
//        min2=min1;
//        min1=nums[i];
//      } else if (nums[i]<min2) {
//        min2=nums[i];
//      }
//
//    }
//    //全正或者全负
//    if (max3>=0|| max1<=0) output=max1*max2*max3;
//    if (min2>=0) {
//      return output;
//    } else {//有正或有负
//      int output1=min1*min2*max1;
//      if (output1>output) return output1;
//      else return output;
//    }
  }

//  public static void main1(String[] args) {
//    Scanner in = new Scanner(System.in);
//    while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//      int a = in.nextInt();
//      int b = in.nextInt();
//      System.out.println(a + b);
//    }
//  }
//
//
//  public static void main2(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int ans = 0, x;
//    for(int i = 0; i < n; i++){
//      for(int j = 0; j < n; j++){
//        x = sc.nextInt();
//        ans += x;
//      }
//    }
//    System.out.println(ans);
//  }
}
