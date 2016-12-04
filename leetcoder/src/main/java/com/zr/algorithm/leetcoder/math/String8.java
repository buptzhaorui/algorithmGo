package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/4
 * Time: 14:30
 */
public class String8 {
  /**
   * 1.去掉空格
   * 2.判断符号
   * 3.溢出停止
   * 4.非数字字符即停止
   */
  public int myAtoi(String str) {
    char[] s = str.toCharArray();
    int sign = 1, base = 0, i = 0, n = s.length;
    while (i < n && s[i] == ' ') { i++; }
    if (i < n && s[i] == '-') { sign = -1; i++;}
    else if(i < n && s[i] == '+') i++;
    while (i < n && s[i] >= '0' && s[i] <= '9') {
      if (base >  Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && s[i] - '0' > 7)) {
        if (sign == 1) return Integer.MAX_VALUE;
        else return Integer.MIN_VALUE;
      }
      base  = 10 * base + (s[i++] - '0');
    }
    return base * sign;
  }
}
