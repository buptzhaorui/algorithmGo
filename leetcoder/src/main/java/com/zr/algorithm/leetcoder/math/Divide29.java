package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/7
 * Time: 10:02
 */
public class Divide29 {
  public int divide(int dividend, int divisor) {
    boolean positive;
    if(dividend == 0) return 0;
    if(divisor == 1) return dividend;
    if(divisor == -1){
      if(dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
      else return -dividend;
    }

    positive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
    long a = Math.abs((long)dividend);
    long b = Math.abs((long)divisor);

    long rst = 0;
    while(a >= b){
      if(positive && rst == Integer.MAX_VALUE) return Integer.MAX_VALUE;
      else if(!positive && rst - 1 == Integer.MAX_VALUE) return Integer.MIN_VALUE;
      else{
        long c = b;
        for(int i = 0; a >= c; i++, c<<=1){
          a -= c;
          rst += 1 << i;
        }
      }
    }

    return positive ? (int)rst : -(int)rst;
  }


  public int divide2(int dividend, int divisor) {
    if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
      return Integer.MAX_VALUE;

    boolean positive = (dividend > 0) == (divisor > 0);
    long a = Math.abs((long)dividend);
    long b = Math.abs((long)divisor);
    long rst = 0;

    while(a >= b){
      long c = b, multiple = 1;
      while(a >= (c << 1)){
        c <<= 1;
        multiple <<= 1;
      }
      a -= c;
      rst += multiple;
    }

    return positive ? (int)rst : -(int)rst;
  }
}
