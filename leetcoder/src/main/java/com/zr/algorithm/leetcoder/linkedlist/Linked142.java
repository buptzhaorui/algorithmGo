package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/8
 * Time: 23:17
 */
public class Linked142 {
  public ListNode detectCycle(ListNode head) {
    ListNode slow, fast;
    slow = fast = head;
    while(fast != null && fast.next != null){
      if(slow.next == fast.next.next){
        slow = head;
        fast = fast.next.next;
        while(slow != fast){
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }else{
        slow = slow.next;
        fast = fast.next.next;
      }
    }
    return null;
  }
}
