package com.zr.algorithm.leetcoder.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2016/10/24
 * Time: 16:07
 */
public class Sum15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> rst = new ArrayList<>();
    Arrays.sort(nums);
    int first = 0;
    int n = nums.length;
    while(first < n - 2){
      int second = first + 1;
      int third = n - 1;
      while(second < third){
        int sum = nums[first] + nums[second] + nums[third];
        if(sum == 0){
          rst.add(Arrays.asList(nums[first], nums[second], nums[third]));
          second++; third--;
          while(second < third && nums[second] == nums[second-1]) second ++;
          while(second < third && nums[third] == nums[third+1]) third --;
        }else if(sum > 0){
          third --;
          while(second < third && nums[third] == nums[third+1]) third --;
        }else{
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
