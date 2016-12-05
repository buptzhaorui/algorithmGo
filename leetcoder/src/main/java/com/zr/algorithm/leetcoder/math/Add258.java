package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/5
 * Time: 13:29
 */
public class Add258 {
  /**
   * num = (a + b + c + d + e) + (a * 9999 + b * 999 + c * 99 + d * 9)
   *
   * x0 = x1 + 9k1
   * x1 = x1 + 9k2
   * ...
   * xn = xn-1 + 9kn
   *
   * x0 = xn + 9(k1 + ... + kn)  xn >= 1 && xn <= 9
   * x0 - 1 = xn - 1 + 9()
   *
   * xn - 1 = (x0 - 1) % 9
   *
   *
   */
  public int addDigits(int num) {
    return (num - 1) % 9 + 1;
  }
}
