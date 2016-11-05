package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/5
 * Time: 13:06
 */
public class Merge21 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode cur, head;
    cur = head = null;
    while(l1 != null && l2 != null){
      if(l1.val < l2.val){
        if(cur == null) head = cur = l1; else cur = cur.next = l1;
        l1 = l1.next;
      }else{
        if(cur == null) head = cur = l2; else cur = cur.next = l2;
        l2 = l2.next;
      }
    }
    if(l1 == null) cur.next = l2;
    if(l2 == null) cur.next = l1;
    return head;
  }
}
