package com.zr.algorithm.leetcoder.dp;

import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2017/2/8
 * Time: 19:42
 */
public class Combination377 {
  public int combinationSum42(int[] nums, int target) {
    int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i - nums[j] >= 0) {
          comb[i] += comb[i - nums[j]];
        }
      }
    }
    return comb[target];
  }
  
  public int combinationSum4(int[] nums, int target) {
    int n = nums.length;
    int[] dp = new int[target + 1];
    dp[0] = 1;
    Arrays.sort(nums);
    for(int i = 1; i <= target; i++){
      for(int j = 0; j < i; j++){
        if(Arrays.binarySearch(nums, i-j) >= 0) dp[i] += dp[j];
      }
    }

    return dp[target];
  }
}
