package com.zr.algorithm.leetcoder.linkedlist;

import java.util.List;

/**
 * User: zhaorui
 * Date: 2016/11/5
 * Time: 17:13
 */
public class Reverse206 {
  private ListNode reverse(ListNode desc, ListNode asc){
    if(asc == null) {
      return desc;
    }
    else{
      ListNode next = asc.next;
      asc.next = desc;
      return reverse(asc, next);
    }
  }

  public ListNode reverseList(ListNode head) {
    if(head == null) return null;

    return reverse(null, head);
  }

  public static void main(String[] args){
    Reverse206 r = new Reverse206();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    n1.next = n2;
    n2.next = null;

    r.reverseList(n1);
  }
}
