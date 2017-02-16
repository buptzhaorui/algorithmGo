package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/16
 * Time: 19:25
 */
public class Partition416 {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for(int num: nums){
      sum += num;
    }

    if(sum % 2 != 0) return false;
    sum /= 2;

    int n = nums.length;
    boolean[] dp = new boolean[sum+1];
    dp[0] = true;

    for(int num: nums){
      for(int j = sum; j >= num; j--){
        dp[j] = dp[j] || dp[j-num];
      }
    }

    return dp[sum];
  }
}
