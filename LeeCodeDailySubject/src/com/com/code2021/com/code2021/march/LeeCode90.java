package com.com.code2021.com.code2021.march;

import com.com.code2021.january.LeeCode978;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description:
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @author: zhongmou.ji
 * @create: 2021/3/31 上午11:10
 **/
public class LeeCode90 {

  List<Integer> t = new ArrayList<Integer>();
  List<List<Integer>> ans = new ArrayList<List<Integer>>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    dfs(false, 0, nums);
    return ans;
  }

  public void dfs(boolean choosePre, int cur, int[] nums) {
    if (cur == nums.length) {
      ans.add(new ArrayList<Integer>(t));
      return;
    }
    dfs(false, cur + 1, nums);
    if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
      return;
    }
    t.add(nums[cur]);
    dfs(true, cur + 1, nums);
    t.remove(t.size() - 1);
  }

  private void backtrack(List<List<Integer>> roads, List<Integer> road,int[] nums,  int index) {
    roads.add(new ArrayList<Integer>(road));
    if (index == nums.length) {
      return;
    }
    for (int i = index; i < nums.length; i++) {
      road.add(nums[i]);
      backtrack(roads, road, nums, index + 1);
      road.remove(road.size() - 1);
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    LeeCode90 leeCode90 = new LeeCode90();
    leeCode90.subsetsWithDup(new int[]{1, 2, 2});
//    File file = new File("/Users/jizhongmou/rsync/aiexpress_gpu_v09_sp02");
//    delete(file);
  }

  private static void delete(File file) throws IOException {
    if (!file.exists()) {
      return;
    }
    if (file.isDirectory()) {
      System.out.println("文件夹：" + file.getName() + "已存在");
      for (File sonFile : file.listFiles()) {
        System.out.println("准备删除子文件" + sonFile.getName());
        delete(sonFile);
      }
    } else {
      System.out.println("删除文件：" + file.getName());
      try {
        Files.delete(file.toPath());
      } catch (Exception e) {
        System.out.println("文件" + file.getName() + "无效，跳过");
      }
    }
    System.out.println("文件夹：" + file.getName() + "子文件已删除， 准备删除文件夹");
    try {
      Files.delete(file.toPath());
    } catch (Exception e) {
      System.out.println("文件夹" + file.getName() + "无效，跳过");
    }
  }
}
