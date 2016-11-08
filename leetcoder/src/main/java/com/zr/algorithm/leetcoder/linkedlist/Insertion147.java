package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/7
 * Time: 21:00
 */
public class Insertion147 {
  public ListNode insertionSortList(ListNode head) {
    if(head == null) return null;
    ListNode cur = head.next;
    head.next = null;
    while(cur != null){
      ListNode p0 = null, p = head;
      while(p != null){
        if(p.val <= cur.val){
          p0 = p;
          p = p.next;
        }else{
          ListNode tmp = cur;
          cur = cur.next;
          if(p == head){
            tmp.next = head;
            head = tmp;
          }else{
            tmp.next = p;
            p0.next = tmp;
          }
          break;
        }
      }
      if(p == null){
        p0.next = cur;
        cur = cur.next;
        p0.next.next = null;
      }
    }

    return head;
  }

  public ListNode insertionSortList2(ListNode head) {
    if( head == null ){
      return head;
    }

    ListNode helper = new ListNode(0); //new starter of the sorted list
    ListNode cur = head; //the node will be inserted
    ListNode pre = helper; //insert node between pre and pre.next
    ListNode next = null; //the next node will be inserted
    //not the end of input list
    while( cur != null ){
      next = cur.next;
      //find the right place to insert
      while( pre.next != null && pre.next.val < cur.val ){
        pre = pre.next;
      }
      //insert between pre and pre.next
      cur.next = pre.next;
      pre.next = cur;
      pre = helper;
      cur = next;
    }

    return helper.next;
  }
}
