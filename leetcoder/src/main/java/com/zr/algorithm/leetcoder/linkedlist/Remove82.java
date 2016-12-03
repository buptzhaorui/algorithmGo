package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/12/3
 * Time: 14:24
 */
public class Remove82 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy, cur = head;
    while(cur != null && cur.next != null){
      ListNode next = cur.next;
      if(cur.val == next.val){
        while(next.next != null && next.val == next.next.val){
          next = next.next;
        }
        pre.next = next.next;
        cur = next.next;
      }else{
        pre = cur;
        cur = next;
      }
    }

    return dummy.next;
  }

  public ListNode deleteDuplicates2(ListNode head) {
    if(head==null) return null;
    ListNode FakeHead=new ListNode(0);
    FakeHead.next=head;
    ListNode pre=FakeHead;
    ListNode cur=head;
    while(cur!=null){
      while(cur.next!=null&&cur.val==cur.next.val){
        cur=cur.next;
      }
      if(pre.next==cur){
        pre=pre.next;
      }
      else{
        pre.next=cur.next;
      }
      cur=cur.next;
    }
    return FakeHead.next;
  }
}
