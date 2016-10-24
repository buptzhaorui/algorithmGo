package com.zr.algorithm.leetcoder.array;

import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2016/10/24
 * Time: 22:30
 */
public class Sum16 {
  public int threeSumClosest(int[] nums, int target) {
    int rst = Integer.MAX_VALUE;
    int minDiff = Integer.MAX_VALUE;
    Arrays.sort(nums);
    int first = 0;
    int n = nums.length;
    while(first < n - 2){
      int second = first + 1;
      int third = n - 1;
      while(second < third){
        int sum = nums[first] + nums[second] + nums[third];
        if(sum == target){
          return target;
        }else if(sum > target){
          int diff = Math.abs(sum - target);
          if(diff < minDiff) {
            minDiff = diff;
            rst = sum;
          }
          third --;
          while(second < third && nums[third] == nums[third+1]) third --;
        }else{
          int diff = Math.abs(sum - target);
          if(diff < minDiff) {
            minDiff = diff;
            rst = sum;
          }
          second ++;
          while(second < third && nums[second] == nums[second-1]) second ++;
        }
      }
      first ++;
      while(first < n - 2 && nums[first] == nums[first-1]) first ++;
    }

    return rst;
  }
}
