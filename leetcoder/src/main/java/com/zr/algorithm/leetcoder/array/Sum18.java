package com.zr.algorithm.leetcoder.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2016/10/25
 * Time: 10:22
 */
public class Sum18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> rst = new ArrayList<>();
    int len = nums.length;
    if(len < 4) return rst;

    Arrays.sort(nums);
    int max = nums[len - 1];
    if(4 * nums[0] > target || 4 * max < target) return rst;

    int i, z;
    for(i = 0; i < len - 3; i++){
      z = nums[i];
      if(i > 0 && z == nums[i-1]) continue;
      if(z + 3 * max < target) continue;
      if(4 * z > target) break;
      if(4 * z == target) {
        if( i + 3 < len && nums[i+3] == z){
          rst.add(Arrays.asList(z, z, z, z));
        }
        break;
      }
      threeSumForFourSum(nums, target - z, i + 1, len - 1, rst, z);
    }

    return rst;
  }

  public void threeSumForFourSum(
    int[] nums, int target, int low, int high,
    List<List<Integer>> rst, int z1) {

    int max = nums[high];
    if(3 * nums[low] > target || 3 * max < target) return;

    int i, z;
    for(i = low; i < high - 1; i++){
      z = nums[i];
      if(i > low && z == nums[i-1]) continue;
      if(z + 2 * max < target) continue;
      if(3 * z > target) break;
      if(3 * z == target) {
        if( i + 2 <= high && nums[i+2] == z){
          rst.add(Arrays.asList(z1, z, z, z));
        }
        break;
      }
      twoSumForFourSum(nums, target - z, i + 1, high, rst, z1, z);
    }
  }

  public void twoSumForFourSum(
    int[] nums, int target, int low, int high,
    List<List<Integer>> rst, int z1, int z2) {

    if(2 * nums[low] > target || 2 * nums[high] < target) return;

    int i = low, j = high, sum, x;
    while(i < j){
      sum = nums[i] + nums[j];
      if(sum == target){
        rst.add(Arrays.asList(z1, z2, nums[i], nums[j]));

        x = nums[i];
        while (++i < j && x == nums[i]) // avoid duplicate
          ;
        x = nums[j];
        while (i < --j && x == nums[j]) // avoid duplicate
          ;
      }else if(sum < target){
        i++;
      }else{
        j--;
      }
    }
  }
}
