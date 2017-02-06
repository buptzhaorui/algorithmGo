package com.zr.algorithm.leetcoder.binary;

/**
 * User: zhaorui
 * Date: 2017/2/5
 * Time: 15:40
 */
public class Find287 {
  public int findDuplicate(int[] nums) {
    int n = nums.length;
    int left = 0, right = n-1;
    while(left < right){
      int mid = (left + right) / 2;
      int count = 0;
      for(int num: nums){
        if(num <= mid) count++;
      }
      if(count > mid) right = mid;
      else left = mid + 1;
    }

    return left;
  }
}
