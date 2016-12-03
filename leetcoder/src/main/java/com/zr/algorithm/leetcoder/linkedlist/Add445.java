package com.zr.algorithm.leetcoder.linkedlist;

import java.util.Stack;

/**
 * User: zhaorui
 * Date: 2016/12/3
 * Time: 12:57
 */
public class Add445 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    while(l1 != null){
      s1.push(l1.val);
      l1 = l1.next;
    }

    while(l2 != null){
      s2.push(l2.val);
      l2 = l2.next;
    }

    ListNode head = new ListNode(0);
    int sum = 0;
    while(!s1.empty() || !s2.empty()){
      sum /= 10;
      if(!s1.empty()){
        int a1 = s1.pop();
        sum += a1;
      }
      if(!s2.empty()){
        int a2 = s2.pop();
        sum += a2;
      }

      ListNode cur = new ListNode(sum % 10);
      cur.next = head.next;
      head.next = cur;
    }

    if(sum / 10 != 0){
      ListNode cur = new ListNode(sum / 10);
      cur.next = head.next;
      head.next = cur;
    }

    return head.next;
  }
}
