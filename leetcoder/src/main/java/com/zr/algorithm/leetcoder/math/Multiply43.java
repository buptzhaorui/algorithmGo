package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/9
 * Time: 11:30
 */
public class Multiply43 {
  private String addStrings(String num1, String num2) {
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

  public String multiply(String num1, String num2) {
    String rst = "";
    int n1 = num1.length();
    int n2 = num2.length();
    if(n1 * n2 == 0) return "";
    String[] s = new String[n1 * n2];

    for(int i1 = 0; i1 < n1; i1++){
      char c1 = num1.charAt(i1);
      for(int i2 = 0; i2 < n2; i2++){
        char c2 = num2.charAt(i2);
        int v = (c1 - '0') * (c2 - '0');
        StringBuilder sbb = new StringBuilder();
        if(v == 0){
          sbb.append(v);
        }else{
          sbb.append(v);
          for(int m = 0; m < i1 + i2; m++) sbb.append(0);
        }
        s[i1 * n2 + i2] = sbb.toString();
      }
    }

    for(int i = 0; i < n1*n2; i++){
      rst = addStrings(rst, s[i]);
    }

    return rst;
  }
}
