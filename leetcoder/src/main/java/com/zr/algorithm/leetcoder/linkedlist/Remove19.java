package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/5
 * Time: 11:51
 */
public class Remove19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null) return head;
    ListNode last = head;
    ListNode nth = head;
    int count = 0;

    while(last.next != null){
      if(count < n){
        last = last.next;
        count ++;
      }else{
        last = last.next;
        nth = nth.next;
      }
    }

    if(count == n){
      nth.next = nth.next.next;
      return head;
    }else{
      return head.next;
    }

  }
}
