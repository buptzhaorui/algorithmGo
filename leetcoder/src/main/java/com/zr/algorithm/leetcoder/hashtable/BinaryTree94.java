package com.zr.algorithm.leetcoder.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * User: zhaorui
 * Date: 2016/11/4
 * Time: 11:55
 */

public class BinaryTree94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> rst = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    HashSet<TreeNode> set = new HashSet<>();
    HashSet<TreeNode> set2 = new HashSet<>();
    if(root == null) return rst;
    stack.push(root);
    while(!stack.empty()){
      TreeNode cur = stack.pop();
      if(cur.right != null && set2.add(cur.right)) {
        stack.push(cur.right);
      }
      if(cur.left == null || set.contains(cur.left)){
        rst.add(cur.val);
        set.add(cur);
      }else{
        stack.push(cur);
        stack.push(cur.left);
      }
    }

    return rst;
  }

  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> rst = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    TreeNode cur = root;
    while(cur != null || !stack.empty()){
      while(cur != null){
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      rst.add(cur.val);
      cur = cur.right;
    }

    return rst;
  }
}
/**
 * Definition for a binary tree node.
 */
 class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
 }