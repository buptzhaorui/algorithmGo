package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/8
 * Time: 21:45
 */
public class Reorder143 {
  public void reorderList(ListNode head) {
    int num = 0;
    ListNode p = head;
    while(p != null){
      num ++;
      p = p.next;
    }
    if(num <= 2) return;

    int i = 1;
    p = head;
    while(i < num/2){
      p = p.next;
      i ++;
    }

    ListNode p2 = null;
    if(num % 2 != 0) p = p.next;
    p2 = p.next;
    p.next = null;

    ListNode p3 = p2.next;
    while(p3 != null){
      ListNode next = p3.next;
      p3.next = p2;
      p2 = p3;
      p3 = next;
    }

    i = 1;
    p = head;
    while(i <= num/2){
      ListNode next = p2.next;
      p2.next = p.next;
      p.next = p2;
      p2 = next;
      p = p.next.next;
      i++;
    }

  }
}
