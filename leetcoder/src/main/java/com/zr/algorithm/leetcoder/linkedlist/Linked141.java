package com.zr.algorithm.leetcoder.linkedlist;

import java.util.HashSet;

/**
 * User: zhaorui
 * Date: 2016/11/4
 * Time: 23:53
 */
public class Linked141 {
  public boolean hasCycle(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();
    ListNode cur = head;
    while(cur != null){
      if(set.add(cur)) cur = cur.next;
      else return true;
    }
    return false;
  }

  public boolean hasCycle2(ListNode head) {
    if(head==null) return false;
    ListNode walker = head;
    ListNode runner = head;
    while(runner.next!=null && runner.next.next!=null) {
      walker = walker.next;
      runner = runner.next.next;
      if(walker==runner) return true;
    }
    return false;
  }
}


class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}