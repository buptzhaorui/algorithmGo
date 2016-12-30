package com.zr.algorithm.leetcoder.string;

import java.util.List;
import java.util.Stack;

/**
 * User: zhaorui
 * Date: 2016/12/30
 * Time: 11:10
 */
public class Mini385 {
  public NestedInteger deserialize(String s) {
    Stack<Character> stack = new Stack<>();
    int cur = 0;
    for(char c: s.toCharArray()){
      switch (c) {
        case '[':

          break;

        case ',':

          break;

        case ']':

          break;

        default:

      }
    }
  }
}

class NestedInteger {
  // onstructor initializes an empty nested list.
  public NestedInteger(){}

     // Constructor initializes a single integer.
      public NestedInteger(int value){}
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){return false;}

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){return 0;}

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value){}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  public void add(NestedInteger ni){}
   // @return the nested list that this NestedInteger holds, if it holds a nested list
   // Return null if this NestedInteger holds a single integer
   public List<NestedInteger> getList(){return null;}
}
