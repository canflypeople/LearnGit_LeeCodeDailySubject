package com.com.code2021.april;

import com.util.TreeNode;

/**
 * @program:
 * @description:
 *
 *
 * @author: zhongmou.ji
 * @create: 2021/4/27 上午10:55
 **/
public class LeetCode938 {

  /**
   * 二叉搜索树，子结点， 左边小，右边大
   *
   *
   * @param root
   * @param low
   * @param high
   * @return
   */
  public int rangeSumBST(TreeNode root, int low, int high) {
    // 给定范围， 中序遍历， 若左边结点比范围要大， 则跳出，若右边结点比范围要小， 退出
    int sum = 0;
    inorder(root, sum, low, high);
    return sum;
  }

  private void inorder(TreeNode node, int sum, int low, int high) {
    if (node == null) {
      return;
    }
    if (node.val < low) {
      inorder(node.right, sum, low, high);
    }
    if (node.val > high) {
      inorder(node.left, sum, low, high);
    }
    if (node.val >= low && node.val <= high) {
      sum += node.val;
    }
  }

  public static void main(String[] args) {
    LeetCode938 leetCode938 = new LeetCode938();
//    leetCode938.rangeSumBST(new int[]{10,5,15,3,7,null,18},7,15);
  }
}
