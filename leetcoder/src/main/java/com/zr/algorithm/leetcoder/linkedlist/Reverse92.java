package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/12/3
 * Time: 13:19
 */
public class Reverse92 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    int i = 1;
    ListNode h0 = new ListNode(0);
    h0.next = head;
    ListNode p1, p2, cur;
    p1 = h0;
    while(i < m){
      p1 = p1.next;
      i ++;
    }
    p2 = p1.next;
    cur = p2.next;
    while(i < n){
      p2.next = cur.next;
      cur.next = p1.next;
      p1.next = cur;
      cur = p2.next;
      i++;
    }

    return h0.next;
  }
}
