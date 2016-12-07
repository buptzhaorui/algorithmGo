package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/7
 * Time: 16:07
 */
public class Perfect279 {
  public int numSquares(int n) {
    if(Math.sqrt((double)n) % 1 == 0) return 1;
    int max = (int)Math.floor(Math.sqrt((double)n));
    int min = (int)Math.floor(Math.sqrt((double)n/2));
    int minimum = Integer.MAX_VALUE;
    for(int i = max; i >= min; i--){
      minimum = Math.min(numSquares(n-i*i)+1, minimum);
    }
    return minimum;
  }
}
