package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/5
 * Time: 19:47
 */
public class Swap24 {
  public ListNode swapPairs(ListNode head) {
    ListNode p0 = null, p1, p2, p3;
    p1 = head;
    while(p1 != null && p1.next != null){
      p2 = p1.next;
      p3 = p2.next;
      p2.next = p1;
      p1.next = p3;
      if(p1 == head){
        head = p2;
      }else{
        p0.next = p2;
      }
      p0 = p1;
      p1 = p3;
    }
    return head;
  }
}
