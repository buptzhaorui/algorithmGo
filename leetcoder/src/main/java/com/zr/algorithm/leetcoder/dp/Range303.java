package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/8
 * Time: 15:32
 */
public class Range303 {

}

class NumArray {
  int[] nums;

  public NumArray(int[] nums) {
    for(int i = 1; i < nums.length; i++)
      nums[i] += nums[i - 1];

    this.nums = nums;
  }

  public int sumRange(int i, int j) {
    if(i == 0)
      return nums[j];

    return nums[j] - nums[i - 1];
  }
}

