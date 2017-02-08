package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/8
 * Time: 16:30
 */
public class House198 {
  public int rob(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0;
    int[] dp = new int[n];
    int max = dp[0] = nums[0];
    for(int i = 1; i < n; i++){
      dp[i] = nums[i];
      if(i-2 >= 0) dp[i] = Math.max(dp[i], dp[i-2]+nums[i]);
      if(i-3 >= 0) dp[i] = Math.max(dp[i], dp[i-3]+nums[i]);
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  public int rob2(int[] num) {
    int prevNo = 0;
    int prevYes = 0;
    for (int n : num) {
      int temp = prevNo;
      prevNo = Math.max(prevNo, prevYes);
      prevYes = n + temp;
    }
    return Math.max(prevNo, prevYes);
  }
}
