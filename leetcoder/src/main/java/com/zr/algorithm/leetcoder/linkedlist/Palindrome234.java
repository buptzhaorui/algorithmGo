package com.zr.algorithm.leetcoder.linkedlist;

import java.util.Stack;

/**
 * User: zhaorui
 * Date: 2016/11/5
 * Time: 19:23
 */
public class Palindrome234 {
  public boolean isPalindrome(ListNode head) {
    if(head == null) return true;
    ListNode cur = head;
    int num = 1;
    while(cur.next != null){
      cur = cur.next;
      num ++;
    }
    Stack<Integer> stack = new Stack<>();
    int index = 1;
    cur = head;
    while(index <= num/2){
      stack.push(cur.val);
      cur = cur.next;
      index ++;
    }
    if(num % 2 == 1){
      cur = cur.next;
      index ++;
    }
    while(index <= num){
      if(stack.pop() == cur.val){
        index ++;
        cur = cur.next;
      }else{
        return false;
      }
    }

    return true;
  }

  boolean isPalindrome2(ListNode head)
  {
    int lenth, i;
    ListNode point1, point2, point3;
    point3 = point2 = head;
    point1 = null;
    lenth = 0;
    if(head == null || head.next == null)
      return true;
    while(point3 != null)//取得长度
    {
      point3 = point3.next;
      lenth++;
    }
    for(i = 0;i < (lenth / 2);i++)//遍历到中间，并逆置
    {
      point3 = point2.next;
      point2.next = point1;
      point1 = point2;
      point2 = point3;
    }
    if((lenth % 2) == 1)
      point3 = point3.next;
    while(point3 != null && point1 != null)//两个指针开始向两头移动，取值比较
    {
      if(point3.val != point1.val)
        return false;
      point3 = point3.next;
      point1 = point1.next;
    }
    return true;//比较中没有发现不同值，则为回文链表
  }
}
