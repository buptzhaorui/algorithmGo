package com.zr.algorithm.leetcoder.linkedlist;

import java.util.*;

/**
 * User: zhaorui
 * Date: 2016/11/10
 * Time: 14:52
 */
public class Convert109 {
  private TreeNode toBST(ArrayList<Integer> arr, int start, int end) {
    if(start > end) return null;

    int mid = start + (end - start >> 1);
    TreeNode root = new TreeNode(arr.get(mid));
    root.left = toBST(arr, start,mid - 1);
    root.right = toBST(arr, mid + 1, end);

    return root;
  }

  private TreeNode toBST2(ListNode head, ListNode tail) {
    if(head == tail) return null;

    ListNode slow = head, fast = head;
    while(fast != tail && fast.next != tail){
      slow = slow.next;
      fast = fast.next.next;
    }

    TreeNode root = new TreeNode(slow.val);
    root.left = toBST2(head, slow);
    root.right = toBST2(slow.next, tail);

    return root;
  }

  private ListNode node = null;

  private TreeNode toBST3(int start, int end) {
    if(start > end) return null;

    int mid = start + (end - start) / 2;
    TreeNode left = toBST3(start, mid-1);
    TreeNode root = new TreeNode(node.val);
    root.left = left;
    node = node.next;
    root.right = toBST3(mid+1, end);
    return root;
  }

  public TreeNode sortedListToBST(ListNode head) {
    ArrayList<Integer> arr = new ArrayList<>();
    while(head != null){
      arr.add(head.val);
      head = head.next;
    }

    return toBST(arr, 0, arr.size() - 1);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
