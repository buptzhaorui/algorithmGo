package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/5
 * Time: 16:50
 */
public class Remove83 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    while(cur != null && cur.next != null){
      if(cur.val == cur.next.val) cur.next = cur.next.next;
      else cur = cur.next;
    }
    return head;
  }
}
