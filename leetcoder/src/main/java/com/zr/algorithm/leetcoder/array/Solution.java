package com.zr.algorithm.leetcoder.array;

/**
 * User: zhaorui
 * Date: 2016/9/1
 * Time: 14:56
 */
public class Solution {

  public int removeElement(int[] nums, int val) {
    int i = 0;
    int j = 0;
    for( ; i < nums.length; i++){
      if(nums[i] == val){
        if(j < i) j = i;

        while(j < nums.length && nums[j] == val){ //find element not equal to val
          j++;
        }

        if(j == nums.length) return i;
        else{
          int temp;
          temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
          j++;
        }
      }
    }
    return i;
  }


  public static void main(String[] args) {
    int[] nums = new int[]{3};
    Solution solution = new Solution();
    int count = solution.removeElement(nums, 2);
    System.out.println("count: " + count);
    for(int i = 0; i < count; i++){
      System.out.println(nums[i]);
    }
  }
}
