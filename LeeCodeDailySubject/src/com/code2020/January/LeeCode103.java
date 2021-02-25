package com.code2020.January;

import com.util.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 */
public class LeeCode103 {

    static int i = 10;

    int j = 0;

    {
        System.out.println(j);
        j = 10;
        System.out.println(j);
    }

    static {
        System.out.println(i);
        i += 10;
        System.out.println(i);
    }

    /**
     * 栈，广度遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(currNode.val);
                } else {
                    levelList.offerFirst(currNode.val);
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(i + ".....");
    }
}
