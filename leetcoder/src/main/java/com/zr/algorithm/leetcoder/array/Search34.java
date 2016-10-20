package com.zr.algorithm.leetcoder.array;

/**
 * User: zhaorui
 * Date: 2016/10/20
 * Time: 15:15
 */
public class Search34 {
  public int[] searchRange(int[] nums, int target) {
    int[] rst = new int[]{-1, -1};
    int left = 0;
    int right = nums.length - 1;

    while(left < right){
      int mid = (left + right) >> 1;
      if(nums[mid] < target) left = mid + 1;
      else if(nums[mid] == target) right = mid;
      else right = mid - 1;
    }

    if(nums[left] == target) rst[0] = left;
    else return rst;

    right = nums.length - 1;
    while(left < right){
      int mid = ((left + right) >> 1) + 1;
      if(nums[mid] > target) right = mid - 1;
      else if(nums[mid] == target) left = mid;
      else left = mid + 1;
    }
    rst[1] = right;

    return rst;
  }
}
