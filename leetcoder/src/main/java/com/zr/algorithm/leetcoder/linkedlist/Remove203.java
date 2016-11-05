package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/5
 * Time: 16:59
 */
public class Remove203 {
  public ListNode removeElements(ListNode head, int val) {
    ListNode pre = null, cur = head;
    while(cur != null){
      if(cur.val == val){
        if(cur == head){
          cur = head = head.next;
        }else{
          cur = pre.next = cur.next;
        }
      }
      else{
        pre = cur;
        cur = cur.next;
      }
    }
    return head;
  }
}
