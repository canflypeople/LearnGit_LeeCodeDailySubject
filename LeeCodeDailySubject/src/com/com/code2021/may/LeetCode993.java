package com.com.code2021.may;

import com.util.TreeNode;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/5/17 上午9:24
 **/
public class LeetCode993 {

  public boolean isCousins(TreeNode root, int x, int y) {
    Queue<List<TreeNode>> queue = new LinkedList<>();
    queue.add(new ArrayList<TreeNode>(Arrays.asList(new TreeNode[]{root})));
    if (root.val == x || root.val == y) {
      return false;
    }
    boolean isFind = false;
    TreeNode xParent = null, yParent = null;
    while (!queue.isEmpty()) {
      List<TreeNode> nodes = queue.poll();
      List<TreeNode> sonNodes = new ArrayList<>();
      for (TreeNode node : nodes) {
        if (node.left != null) {
          sonNodes.add(node.left);
          if (node.left.val == x) {
            isFind = true;
            xParent = node;
          } else if (node.left.val == y) {
            isFind = true;
            yParent = node;
          }
        }
        if (node.right != null) {
          sonNodes.add(node.right);
          if (node.right.val == x) {
            isFind = true;
            xParent = node;
          } else if (node.right.val == y) {
            isFind = true;
            yParent = node;
          }
        }
      }
      if (isFind) {
        return (xParent != null && yParent != null) && (xParent != yParent);
      }
      queue.offer(sonNodes);
    }
    return false;
  }


}
