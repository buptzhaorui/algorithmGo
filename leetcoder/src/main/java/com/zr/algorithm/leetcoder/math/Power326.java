package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/5
 * Time: 21:51
 */
public class Power326 {
  /**
   * 由于输入是int，正数范围是0-231，
   * 在此范围中允许的最大的3的次方数为319=1162261467，
   * 那么我们只要看这个数能否被n整除即可
   */
  public boolean isPowerOfThree(int n) {
    return n > 0 && 1162261467 % n == 0;
  }

  /**
   * 求对数，然后乘方，判断得数是否相等
   * https://discuss.leetcode.com/topic/33536/a-summary-of-all-solutions-new-method-included-at-15-30pm-jan-8th/2
   */
  public boolean isPowerOfThree2(int n) {
    return n != 0 && n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
  }
}
