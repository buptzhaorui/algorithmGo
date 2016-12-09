package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/8
 * Time: 23:10
 */
public class Minimum462 {
  public int minMoves2(int[] nums) {
    int rst = 0;
    int left = 0, right = nums.length - 1;
    while(left < right){
      rst += nums[right--] - nums[left++];
    }

    return rst;
  }
}
