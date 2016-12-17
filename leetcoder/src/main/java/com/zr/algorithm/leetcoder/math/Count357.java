package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/15
 * Time: 21:34
 */
public class Count357 {
  public int countNumbersWithUniqueDigits(int n) {
    if(n == 0) return 1;
    if(n == 1) return 10;
    int rst = 10;
    for(int i = 2; i <= n; i++){
      int tmp = 9;
      for(int j = 9; j >= 9 - i + 2; j--){
        tmp *= j;
      }
      rst += tmp;
    }
    return rst;
  }
}
