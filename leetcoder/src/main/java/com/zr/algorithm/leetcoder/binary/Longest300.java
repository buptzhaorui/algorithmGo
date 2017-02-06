package com.zr.algorithm.leetcoder.binary;

import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2017/2/5
 * Time: 14:26
 */
public class Longest300 {
  public int lengtOfLIS(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0;
    int[] dp = new int[n];
    dp[0] = 1;

    int rst = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < i; j++){
        if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
      }
      dp[i] = dp[i] == 0 ? 1: dp[i];
      rst = Math.max(rst, dp[i]);
    }
    return rst;
  }
  public int lengthOfLIS2(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;

    for(int x : nums) {
      int i = Arrays.binarySearch(dp, 0, len, x);
      if(i < 0) i = -(i + 1);
      dp[i] = x;
      if(i == len) len++;
    }

    return len;
  }
}
