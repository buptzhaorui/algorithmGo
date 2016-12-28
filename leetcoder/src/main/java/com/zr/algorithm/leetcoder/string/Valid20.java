package com.zr.algorithm.leetcoder.string;

import java.util.Stack;

/**
 * User: zhaorui
 * Date: 2016/12/28
 * Time: 17:17
 */
public class Valid20 {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(char c: s.toCharArray()){
      switch (c) {
        case '(': case '[': case '{':
          stack.push(c);
          break;
        case ')':
          if(stack.empty() || stack.pop() != '(') return false;
          break;
        case ']':
          if(stack.empty() || stack.pop() != '[') return false;
          break;
        case '}':
          if(stack.empty() || stack.pop() != '{') return false;
          break;
      }
    }
    return stack.empty();
  }
}
