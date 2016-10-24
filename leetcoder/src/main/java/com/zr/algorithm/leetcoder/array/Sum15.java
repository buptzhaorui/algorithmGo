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
    HashSet<Integer> centers = new HashSet<>();
    Arrays.sort(nums);
    int center = 0;
    int n = nums.length;
    while(center < n){
      int left = center - 1;
      int right = center + 1;
      while(left >= 0 && right < n){
        int sum = nums[left] + nums[center] + nums[right];
        if(sum == 0){
          List<Integer> tmp = new ArrayList<>();
          centers.add(nums[center]);
          tmp.add(nums[left]);
          tmp.add(nums[center]);
          tmp.add(nums[right]);
          rst.add(tmp);
          left --;
          while(left >= 0 && nums[left] == nums[left+1]) left --;
          right ++;
          while(right < n && nums[right] == nums[right-1]) right ++;
        }else if(sum < 0){
          right ++;
          while(right < n && nums[right] == nums[right-1]) right ++;
        }else{
          left --;
          while(left >= 0 && nums[left] == nums[left+1]) left --;
        }
      }
      center ++;
      while(center < n && nums[center] == nums[center-1] && centers.contains(nums[center])) center ++;
    }

    return rst;
  }
}
