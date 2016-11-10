package com.zr.algorithm.leetcoder.linkedlist;

/**
 * User: zhaorui
 * Date: 2016/11/10
 * Time: 11:47
 */
public class Odd328 {
  public ListNode oddEvenList(ListNode head) {
    ListNode cur, oddHead, evenHead, oddTail, evenTail;
    boolean isOdd = true;
    oddHead = oddTail = new ListNode(0);
    evenHead = evenTail = new ListNode(0);
    cur = head;
    while(cur != null){
      ListNode next = cur.next;
      cur.next = null;
      if(isOdd){
        oddTail = oddTail.next = cur;
        isOdd = false;
      }else{
        evenTail = evenTail.next = cur;
        isOdd = true;
      }
      cur = next;
    }
    oddTail.next = evenHead.next;
    return oddHead.next;
  }

  public static void main(String[] args) {
    ListNode n1, n2, n3;
    n1 = new ListNode(1);
    n2 = new ListNode(2);
    n3 = new ListNode(3);
    n1.next = n2;
    n2.next = n3;
    new Odd328().oddEvenList(n1);

  }
}
