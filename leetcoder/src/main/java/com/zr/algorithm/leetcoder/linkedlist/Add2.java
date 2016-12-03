package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/12/3
 * Time: 11:11
 */
public class Add2 {
  class ProcessRst {
    int carry;
    ListNode rst;
    public ProcessRst(int carry, ListNode rst){
      this.carry = carry;
      this.rst = rst;
    }
  }

  private ProcessRst processL(ListNode l, ListNode rst, int carry) {
    while(l != null){
      if(carry == 0){
        rst.next = l;
        break;
      }else{
        int val = l.val + carry;
        carry = val / 10;
        val = val % 10;
        rst.next = new ListNode(val);
        rst = rst.next;
        l = l.next;
      }
    }
    return new ProcessRst(carry, rst);
  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode rst = new ListNode(0);
    ListNode head = rst;
    int carry = 0;
    while(l1 != null && l2 != null){
      int val = l1.val + l2.val + carry;
      carry = val / 10;
      val = val % 10;
      rst.next = new ListNode(val);
      rst = rst.next;
      l1 = l1.next;
      l2 = l2.next;
    }


    ProcessRst prst1 = processL(l1, rst, carry);
    ProcessRst prst2 = processL(l2, prst1.rst, prst1.carry);

    if(prst2.carry != 0)
      prst2.rst.next = new ListNode(prst2.carry);

    return head.next;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode c1 = l1;
    ListNode c2 = l2;
    ListNode sentinel = new ListNode(0);
    ListNode d = sentinel;
    int sum = 0;
    while (c1 != null || c2 != null) {
      sum /= 10;
      if (c1 != null) {
        sum += c1.val;
        c1 = c1.next;
      }
      if (c2 != null) {
        sum += c2.val;
        c2 = c2.next;
      }
      d.next = new ListNode(sum % 10);
      d = d.next;
    }
    if (sum / 10 == 1)
      d.next = new ListNode(1);
    return sentinel.next;
  }
}
