package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/4
 * Time: 18:56
 */
public class Add415 {
  public String addStrings(String num1, String num2) {
    int l1 = num1.length();
    int l2 = num2.length();
    int carry = 0;
    int i = 0;
    StringBuilder rst = new StringBuilder();
    while(i < l1 || i < l2){
      if(i < l1){
        char c = num1.charAt(l1-1-i);
        int v = c - '0';
        carry += v;
      }
      if(i < l2){
        char c = num2.charAt(l2-1-i);
        int v = c - '0';
        carry += v;
      }
      rst.insert(0, carry%10);
      carry /= 10;
      i++;
    }
    if(carry != 0) rst.insert(0, carry);
    return rst.toString();
  }
}
