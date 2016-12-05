package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/5
 * Time: 21:21
 */
public class Reverse7 {
  public int reverse(int x) {
    int rst = 0;
    while(x != 0){
      if(x < 0){
        int b = x % 10;
        if(rst >= Integer.MIN_VALUE / 10 && rst * 10 >= Integer.MIN_VALUE - b){
          rst = rst * 10 + b;
          x /= 10;
        }else{
          return 0;
        }
      }else{
        int b = x % 10;
        if(rst <= Integer.MAX_VALUE / 10 && rst * 10 <= Integer.MAX_VALUE - b){
          rst = rst * 10 + b;
          x /= 10;
        }else{
          return 0;
        }
      }
    }
    return rst;
  }
}
