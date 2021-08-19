package com.util;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/4/26 上午9:55
 **/
public class SortUtils {

  class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
      this.val = val;
    }
  }

  /**
   * 堆排序， 大顶堆, 父结点比左右叶子结点都大
   * 排序步骤：
   * 1. 先初始化堆
   * 2.遍历倒数第二层子结点，判断是否符合要求， 不符合则交换位置， 直到父结点， 将父结点记录下， 父节点和最后一个结点交换位置
   * @param nums
   */
  public void heapSort(int[] nums) {


  }
}
