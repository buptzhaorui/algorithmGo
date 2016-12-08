package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/8
 * Time: 17:13
 */
public class Ugly264 {
  /**
   * The naive approach is to call isUgly for every number until you reach the nth one.
   * Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
   * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
   * The key is how to maintain the order of the ugly numbers.
   * Try a similar approach of merging from three sorted lists: L1, L2, and L3.
   * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
   */
  public int nthUglyNumber(int n) {
    int[] ugly = new int[n];
    ugly[0] = 1;
    int p2 = 0, p3 = 0, p5 = 0;
    for(int i = 1; i < n; i++){
      ugly[i] = Math.min(Math.min(ugly[p2] * 2, ugly[p3] * 3), ugly[p5] * 5);
      if(ugly[i] == ugly[p2] * 2) p2++;
      else if(ugly[i] == ugly[p3] * 3) p3++;
      else p5++;
    }
    return ugly[n-1];
  }
}
