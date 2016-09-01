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


  public int removeElement2(int[] nums, int val) {
    int j = 0;

    for(int i = 0; i < nums.length; i++) {
      if(nums[i] != val){
        nums[j] = nums[i];
        j++;
      }
    }

    return j;
  }


  public static void main(String[] args) {
    int[] nums = new int[]{3,2,34,2,2};
    Solution solution = new Solution();
    int count = solution.removeElement2(nums, 2);
    System.out.println("count: " + count);
    for(int i = 0; i < count; i++){
      System.out.println(nums[i]);
    }
  }
}
