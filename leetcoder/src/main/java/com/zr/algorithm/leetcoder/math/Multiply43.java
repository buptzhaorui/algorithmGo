package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/9
 * Time: 11:30
 */
public class Multiply43 {
  public String multiply(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();
    if(n1 * n2 == 0) return "";
    int[] s = new int[n1 + n2];

    for(int i1 = n1 - 1; i1 >= 0; i1 --){
      char c1 = num1.charAt(i1);
      int carry = 0;
      for(int i2 = n2 - 1; i2 >= 0; i2 --){
        char c2 = num2.charAt(i2);
        int multiply = (c1 - '0') * (c2 - '0');
        int sum = s[i1+i2+1] + multiply + carry;
        s[i1+i2+1] = sum % 10;
        carry = sum / 10;
      }
      s[i1] += carry;
    }

    StringBuilder sb = new StringBuilder();
    boolean prefix0 = true;
    for(int i = 0; i < n1 + n2; i++){
      if(prefix0 && s[i] != 0){
        sb.append(s[i]);
        prefix0 = false;
      }else if(!prefix0 || i == n1+n2-1){
        sb.append(s[i]);
      }
    }

    return sb.toString();
  }
}
