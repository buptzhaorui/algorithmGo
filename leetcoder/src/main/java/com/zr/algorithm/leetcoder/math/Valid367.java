package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/15
 * Time: 16:54
 */
public class Valid367 {
  public boolean isPerfectSquare(int num) {
    if(num <= 0) return false;
    int left = 0;
    int right = num;
    while(left <= right){
      int mid = left + (right - left) / 2;
      System.out.println(mid);
      if(mid * mid == num)
        return true;
      else if(mid == 0 || mid < num / mid)
        left = mid + 1;
      else
        right = mid - 1;
    }

    return false;
  }

  public boolean isPerfectSquare2(int num) {
    int i = 1;
    while (num > 0) {
      num -= i;
      i += 2;
    }
    return num == 0;
  }

  public boolean isPerfectSquare3(int num) {
    long x = num;
    while (x * x > num) {
      x = (x + num / x) >> 1;
    }
    return x * x == num;
  }
}
