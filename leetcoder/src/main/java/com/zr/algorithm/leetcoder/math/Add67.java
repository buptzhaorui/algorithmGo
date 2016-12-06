package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/6
 * Time: 17:13
 */
public class Add67 {
  public String addBinary(String a, String b) {
    int i = 0;
    int na = a.length(), nb = b.length();
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while(i < na || i < nb){
      if(i < na){
        carry += a.charAt(na-1-i) - '0';
      }
      if(i < nb){
        carry += b.charAt(nb-1-i) - '0';
      }
      sb.insert(0, carry % 2);
      carry /= 2;
      i++;
    }
    if(carry != 0) sb.insert(0, carry);
    return sb.toString();
  }
}
