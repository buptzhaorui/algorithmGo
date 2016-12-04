package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/12/3
 * Time: 15:11
 */
public class Partition86 {
  public ListNode partition(ListNode head, int x) {
    ListNode dummy1 = new ListNode(0);
    ListNode dummy2 = new ListNode(0);
    ListNode tail1 = dummy1, tail2 = dummy2;
    while(head != null){
      ListNode next = head.next;
      if(head.val < x){
        tail1.next = head;
        tail1 = tail1.next;
      }else{
        tail2.next = head;
        tail2 = tail2.next;
      }

      head = next;
    }

    tail2.next = null;
    tail1.next = dummy2.next;
    return dummy1.next;
  }
}
