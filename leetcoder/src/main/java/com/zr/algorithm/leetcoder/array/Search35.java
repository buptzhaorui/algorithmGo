package com.zr.algorithm.leetcoder.array;

/**
 * User: zhaorui
 * Date: 2016/10/19
 * Time: 21:46
 */
public class Search35 {
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;

    while(left < right){
      int mid = (left + right) >> 1;
      if(nums[mid] == target){
        return mid;
      }else if(nums[mid] < target){
        left = mid + 1;
      }else{
        right = mid - 1;
      }
    }

    if(target > nums[left]) return left + 1;
    else return left;
  }
}
