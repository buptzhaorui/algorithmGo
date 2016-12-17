package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/15
 * Time: 20:09
 */
public class Water365 {
  /**
   * 贝祖定理: 存在a,b使得 ax+by = gcd(x, y) = d
   *
   * z = a'x+b'y
   *
   * 只要z % d == 0，就存在a' 和 b'满足条件
   *
   * 系数为正，代表倒满水，为负，代表倒空，所以只要z是1到x+y的最大值直接的最大公约数的倍数就可以
   *
   */


  private int gcd(int x, int y){
    return y == 0 ? x : gcd(y, x % y);
  }
  public boolean canMeasureWater(int x, int y, int z) {
    return z == 0 ||  (z - x <= y && z % gcd(x, y) == 0);
  }
}
