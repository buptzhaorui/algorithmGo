package com.zr.algorithm.leetcoder.array;

/**
 * User: zhaorui
 * Date: 2016/10/19
 * Time: 20:45
 */
public class Container11 {
  public int maxArea(int[] height) {
    int max = 0;
    int left = 0;
    int right = height.length-1;

    while(left < right){
      int lh = height[left];
      int rh = height[right];
      max = Math.max(max, Math.min(lh, rh)*(right-left));
      if(lh < rh){
        while(left < right && height[left] <= lh) left++;
      }else{
        while(left < right && height[right] <= rh) right--;
      }
    }

    return max;
  }
}
