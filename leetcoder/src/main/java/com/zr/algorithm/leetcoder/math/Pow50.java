package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/13
 * Time: 21:47
 */
public class Pow50 {
  public double myPow(double x, int n) {
    if(n == 0) return 1;
    boolean sign = true;
    if(n < 0){
      sign = false;
      n = Math.abs(n);
    }
    double rst = 1;
    while(n > 0){
      int base = 1;
      double tmp = x;
      while(2*base <= n){
        base *= 2;
        tmp *= tmp;
      }
      n -= base;
      rst *= tmp;
    }
    return sign ? rst: 1/rst;
  }

  public double myPow2(double x, int n) {
    if(n == 0)
      return 1;
    if (n < 0) {
      return 1 / (x * myPow(x, -(n + 1)));
    }
    return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
  }
}
