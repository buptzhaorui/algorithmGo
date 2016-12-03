package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/12/3
 * Time: 13:45
 */
public class Rotate61 {
  public ListNode rotateRight(ListNode head, int k) {
    if(k == 0) return head;
    int n = 0;
    ListNode p = head;
    while(p != null){
      n++;
      p = p.next;
    }
    if(n == 0 || n == 1 || k % n == 0) return head;
    k = k % n;

    ListNode h0 = new ListNode(0);
    h0.next = head;
    p = head;
    int i = 1;
    while(i < n-k){
      p = p.next;
      i ++;
    }

    ListNode cur = p.next;
    p.next = null;
    h0.next = cur;
    while(k > 1){
      cur = cur.next;
      k--;
    }

    cur.next= head;

    return h0.next;
  }

  public ListNode rotateRight2(ListNode head, int n) {
    if (head==null||head.next==null) return head;
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode fast=dummy,slow=dummy;

    int i;
    for (i=0;fast.next!=null;i++)//Get the total length
      fast=fast.next;

    for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
      slow=slow.next;

    fast.next=dummy.next; //Do the rotation
    dummy.next=slow.next;
    slow.next=null;

    return dummy.next;
  }
}
