package com.zr.algorithm.leetcoder.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2016/12/15
 * Time: 14:56
 */
public class Largest368 {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    if(nums.length == 0) return new ArrayList<Integer>();
    Arrays.sort(nums);
    int n = nums.length;
    int maxNum = 0;
    int maxPos = -1;
    int[] prePos = new int[n]; //记录集合中nums[i]的上一个索引
    int[] maxArr = new int[n]; // 记录以nums[i]为结尾的集合最大个数

    for(int i = 0; i < n; i++){
      maxArr[i] = 1;
      prePos[i] = -1;
      for(int j = 0; j < i; j++){
        if(nums[i] % nums[j] == 0 && maxArr[j] + 1 > maxArr[i]){
          maxArr[i] = maxArr[j] + 1;
          prePos[i] = j;
        }
      }
      if(maxArr[i] > maxNum){
        maxNum = maxArr[i];
        maxPos = i;
      }
    }

    ArrayList<Integer> rst = new ArrayList<>();
    while(prePos[maxPos] != -1){
      rst.add(nums[maxPos]);
      maxPos = prePos[maxPos];
    }

    rst.add(nums[maxPos]);

    return rst;
  }

  public List<Integer> largestDivisibleSubset2(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();
    if (nums == null || nums.length == 0) return res;
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    dp[0] = 1;

    //for each element in nums, find the length of largest subset it has.
    for (int i = 1; i < nums.length; i++){
      for (int j = i-1; j >= 0; j--){
        if (nums[i] % nums[j] == 0){
          dp[i] = Math.max(dp[i],dp[j] + 1);
        }
      }
    }

    //pick the index of the largest element in dp.
    int maxIndex = 0;
    for (int i = 1; i < nums.length; i++){
      maxIndex = dp[i] > dp[maxIndex] ?  i :  maxIndex;
    }

    //from nums[maxIndex] to 0, add every element belongs to the largest subset.
    int temp = nums[maxIndex];
    int curDp = dp[maxIndex];
    for (int i = maxIndex; i >= 0; i--){
      if (temp % nums[i] == 0 && dp[i] == curDp){
        res.add(nums[i]);
        temp = nums[i];
        curDp--;
      }
    }
    return res;
  }
}
