package com.zr.algorithm.leetcoder.binary;

import java.util.Stack;

/**
 * User: zhaorui
 * Date: 2017/2/6
 * Time: 16:39
 */
public class Kth230 {
  private static int num;
  private static int count;

  private void inOrder(TreeNode root){
    if(root.left != null) inOrder(root.left);

    if(count == 0){
      return;
    }
    count --;
    num = root.val;

    if(root.right != null) inOrder(root.right);
  }

  public int kthSmallest(TreeNode root, int k) {
    count = k;
    inOrder(root);
    return num;
  }
}


 class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
 }