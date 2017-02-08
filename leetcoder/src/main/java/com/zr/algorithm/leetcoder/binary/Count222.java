package com.zr.algorithm.leetcoder.binary;

/**
 * User: zhaorui
 * Date: 2017/2/7
 * Time: 15:39
 */
public class Count222 {
  int height(TreeNode root) {
    return root == null ? -1 : 1 + height(root.left);
  }
  public int countNodes(TreeNode root) {
    int h = height(root);
    return h < 0 ? 0 :
      height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
        : (1 << h-1) + countNodes(root.left);
  }
}
