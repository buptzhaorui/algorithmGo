package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/14
 * Time: 12:42
 */
public class Counting338 {
  public int[] countBits(int num) {
    int[] dp = new int[num+1];
    if(num == 0) return dp;
    dp[1] = 1;
    int base = 2;

    for(int i = 2; i <= num; i++){
      if(i == base){
        dp[i] = 1;
        base *= 2;
      }else{
        dp[i] = dp[i - base/2] + 1;
      }
    }

    return dp;
  }
}
