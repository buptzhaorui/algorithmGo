package com.zr.algorithm.leetcoder.dp;

import sun.nio.cs.ext.MacHebrew;

/**
 * User: zhaorui
 * Date: 2017/2/9
 * Time: 20:00
 */
public class Wiggle376 {
  public int wiggleMaxLength(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0;
    int[] pos = new int[n];
    int[] neg = new int[n];

    pos[0] = neg[0] = 1;
    int rst = 1;
    for(int i = 1; i < n; i++){
      for(int j = 0; j < i; j++){
        if(nums[i] > nums[j]){
          pos[i] = Math.max(pos[i], neg[j]+1);
        }else if(nums[i] < nums[j]){
          neg[i] = Math.max(neg[i], pos[j]+1);
        }else{
          pos[i] = Math.max(pos[i], 1);
          neg[i] = Math.max(neg[i], 1);
        }
      }
      rst = Math.max(rst, Math.max(pos[i], neg[i]));
    }
    return rst;
  }
}
