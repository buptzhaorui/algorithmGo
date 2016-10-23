package com.zr.algorithm.leetcoder.array;

/**
 * User: zhaorui
 * Date: 2016/10/23
 * Time: 12:02
 */
public class Minimum209 {
  public int minSubArrayLen(int s, int[] nums) {
    int rst = 0;
    int sum, i, j;
    i = j = 0;
    int n = nums.length;
    if(n > 0) sum = nums[0];
    else return rst;

    while(j < n){
      if(sum >= s){
        if(rst == 0) rst = j - i + 1;
        else rst = Math.min(rst, j - i + 1);
        sum -= nums[i++];
      }else{
        if(++j == n) break;
        else sum += nums[j];
      }
    }

    return rst;
  }
}
