package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/4
 * Time: 13:50
 */
public class Factorial172 {
  //每当乘积因子多一对2和5，结果会多一个0，并且5的个数一定小于2，因此题目可以转换成1到n可以分解成多少个5
  //sum(n/5， n/25, n/125...)
  public int trailingZeroes(int n) {
    int count5 = 0;
    while(n/5 != 0){
      n /= 5;
      count5 += n;
    }
    return count5;
  }

  // return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5); !!!!!!!!!!!!!!!!!!!!!!!!
}
