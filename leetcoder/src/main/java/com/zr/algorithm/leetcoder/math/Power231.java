package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/6
 * Time: 16:22
 */
public class Power231 {
  //https://discuss.leetcode.com/topic/47195/4-different-ways-to-solve-iterative-recursive-bit-operation-math
  public boolean isPowerOfTwo(int n) {
    return n != 0 && Math.pow(2, Math.round(Math.log(n) / Math.log(2))) == n;

    //return n != 0 && (n & (n-1)) == 0;
    //return n>0 && (1073741824 % n == 0);
  }
}
