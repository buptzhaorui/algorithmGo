package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/8
 * Time: 23:10
 */
public class Minimum462 {
  public int minMoves2(int[] nums) {
    int n = nums.length;
    if(n < 2) return 0;
    long total = 0;
    for(int i = 0; i < n; i++){
      total += nums[i];
    }
    long mid = Math.round((double)total/n);
    int rst = 0;
    for(int i = 0; i < n; i++){
      rst += Math.abs(nums[i] - mid);
    }

    return rst;
  }
}
