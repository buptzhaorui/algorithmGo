package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/6
 * Time: 16:42
 */
public class Ugly263 {
  public boolean isUgly(int num) {
    if(num == 0) return false;
    while(num != 1){
      if(num % 2 == 0){
        num /= 2;
      }else if(num % 3 == 0){
        num /= 3;
      }else if(num % 5 == 0){
        num /= 5;
      }else{
        return false;
      }
    }
    return true;
  }

  public boolean isUgly2(int num) {
    if (num > 0)
      for (int i=2; i<6; i++)
        while (num % i == 0)
          num /= i;
    return num == 1;
  }
}
