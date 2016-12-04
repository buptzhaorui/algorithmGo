package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/4
 * Time: 16:55
 */
public class Arranging441 {
  public int arrangeCoins(int n) {
    int i = 0;
    while(n > i){
      i++;
      n -= i;
    }
    return i;
  }
}
