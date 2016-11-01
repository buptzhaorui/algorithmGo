package com.zr.algorithm.leetcoder.hashtable;

/**
 * User: zhaorui
 * Date: 2016/11/1
 * Time: 16:53
 */
public class Fraction166 {
  public String fractionToDecimal(int numerator, int denominator) {
    int integetPart = numerator / denominator;
    int decimalPart = numerator % denominator;
    if(decimalPart == 0){
      return integetPart + "";
    }else {
      String rst = ".";
      int[] v = new int[denominator];
      int index = 1; //base on 1
      int a, b = decimalPart;
      while (b != 0 && v[b] == 0) {
        v[b] = index;
        a = b * 10 / denominator;
        b = b * 10 % denominator;
        rst += a;
      }
      if (v[b] != 0) rst = rst.substring(0, v[b]) + "(" + rst.substring(v[b]) + ")";
      return integetPart + rst;
    }
  }
}
