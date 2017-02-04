package com.zr.algorithm.leetcoder.string;

import java.util.Stack;

/**
 * User: zhaorui
 * Date: 2017/2/4
 * Time: 15:12
 */
public class Basic227 {
  public int calculate(String s) {
    int len;
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for(int i=0;i<len;i++){
      if(Character.isDigit(s.charAt(i))){
        num = num*10+s.charAt(i)-'0';
      }
      if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
        if(sign=='-'){
          stack.push(-num);
        }
        if(sign=='+'){
          stack.push(num);
        }
        if(sign=='*'){
          stack.push(stack.pop()*num);
        }
        if(sign=='/'){
          stack.push(stack.pop()/num);
        }
        sign = s.charAt(i);
        num = 0;
      }
    }

    int re = 0;
    for(int i:stack){
      re += i;
    }
    return re;
  }
}
