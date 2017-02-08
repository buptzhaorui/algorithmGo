package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/8
 * Time: 17:39
 */
public class Climbing70 {
  public int climbStairs(int n) {
    if(n == 0 || n == 1 || n == 2) return n;

    int pre1 = 1;
    int pre2 = 2;
    for(int i = 3; i <= n; i++){
      int tmp = pre2;
      pre2 = pre1 + pre2;
      pre1 = tmp;
    }

    return pre2;
  }
}
