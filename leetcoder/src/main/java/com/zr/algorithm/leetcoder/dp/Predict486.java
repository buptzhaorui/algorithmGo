package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/16
 * Time: 20:20
 */
public class Predict486 {
  public boolean PredictTheWinner(int[] nums) {
    return helper(nums, 0, nums.length-1)>=0;
  }
  private int helper(int[] nums, int s, int e){
    return s==e ? nums[e] : Math.max(nums[e] - helper(nums, s, e-1), nums[s] - helper(nums, s+1, e));
  }
}
