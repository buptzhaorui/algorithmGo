package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/4
 * Time: 19:27
 */
public class Nth400 {
  public int findNthDigit(int n) {
    int base = 9, times = 1, num = 0;
    while(n > ((long)base)*times){
      num += base;
      n = n - base*times;
      base *= 10;
      times ++;
    }

    num += n/times;
    StringBuilder sb = new StringBuilder();
    sb.append(num % 10);
    sb.append(num + 1);

    return sb.toString().charAt(n%times)-'0';
  }
}
