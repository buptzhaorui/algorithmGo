package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/8
 * Time: 18:53
 */
public class Sqrt69 {
  //binary search
  public int mySqrt(int x) {
    if(x < 2) return x;
    int left = 0, right = x;
    while(left < right){
      int i = left + (right - left) / 2;
      if(i <= x / i && (i+1) > x / (i+1)) return i;
      else if((i+1) == x / (i+1)) return i+1;
      else if(i > x / i){
        right = i - 1;
      }else{
        left = i + 1;
      }
    }

    return left;
  }

  public int sqrt(int x) {
    if (x == 0)
      return 0;
    int left = 1, right = Integer.MAX_VALUE;
    while (true) {
      int mid = left + (right - left)/2;
      if (mid > x/mid) {
        right = mid - 1;
      } else {
        if (mid + 1 > x/(mid + 1))
          return mid;
        left = mid + 1;
      }
    }
  }
}
