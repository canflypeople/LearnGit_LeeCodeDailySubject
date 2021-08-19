package com.com.code2021.may;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/10 上午9:22
 **/
public class LeetCode872 {

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> sonNodeList1 = getSonNodeList(root1);
    List<Integer> sonNodeList2 = getSonNodeList(root2);
    return sonNodeList1.equals(sonNodeList2);
  }

  private boolean isSameValueList(List<Integer> sonNodeList1, List<Integer> sonNodeList2) {
    if (sonNodeList1.size() != sonNodeList2.size()) {
      return false;
    }
    int len = sonNodeList1.size();
    for (int i = 0; i < len; i++) {
      if (!sonNodeList1.get(i).equals(sonNodeList2.get(i))) {
        return false;
      }
    }
    return true;
  }

  private List<Integer> getSonNodeList(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    getSonNodeList(root, ans);
    return ans;
  }

  private void getSonNodeList(TreeNode root, List<Integer> ans) {
    if (root == null) {
      return;
    }
    getSonNodeList(root.left, ans);
    if (root.left == null && root.right == null) {
      ans.add(root.val);
      return;
    }
    getSonNodeList(root.right, ans);
  }

  public static void main(String[] args) {
    A a = new B();
    a.testA();
  }

}

class A {
  public void testA() {
    testB();
  }

  public void testB() {
    // Class A TODO
    System.out.println("A do");
  }
}

class B extends A {
  @Override
  public void testA() {
    super.testA();
  }

  @Override
  public void testB() {
    // Class B TODO
    System.out.println("B do");
  }
}
