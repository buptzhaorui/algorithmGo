package com.zr.algorithm.leetcoder.math;

import java.util.*;

/**
 * User: zhaorui
 * Date: 2016/12/5
 * Time: 13:43
 */
public class Minimum453 {
  private void sortHelper(int[] nums, int index) {
    while(index > 0 && nums[index] < nums[index-1]){
      int tmp = nums[index];
      nums[index] = nums[index-1];
      nums[index-1] = tmp;
      index --;
    }
  }
  public int minMoves(int[] nums) {
    int n = nums.length;
    if(n < 2) return 0;
    Arrays.sort(nums);
    int count = 0;
    while(nums[0] != nums[n-1]){
      nums[n-1] --;

      count++;
    }

    return count;
  }
}
