package com.zr.algorithm.leetcoder.hashtable;

import java.util.HashMap;

/**
 * User: zhaorui
 * Date: 2016/11/1
 * Time: 16:53
 */
public class Fraction166 {
  private String positiveFractionToDecimal(long numerator, long denominator){
    long integetPart = numerator / denominator;
    long decimalPart = numerator % denominator;
    if(decimalPart == 0){
      return integetPart + "";
    }else {
      String rst = ".";
      HashMap<Long, Integer> map = new HashMap<>();
      int index = 1; //base on 1
      long a, b = decimalPart;
      while (b != 0 && !map.containsKey(b)) {
        map.put(b, index++);
        a = b * 10 / denominator;
        b = b * 10 % denominator;
        rst += a;
      }
      if (map.containsKey(b)) {
        int i = map.get(b);
        rst = rst.substring(0, i) + "(" + rst.substring(i) + ")";
      }
      return integetPart + rst;
    }
  }
  public String fractionToDecimal(long numerator, long denominator) {
    if(numerator == 0) return "0";

    if((numerator > 0 && denominator > 0) || numerator < 0 && denominator < 0){
      return positiveFractionToDecimal(Math.abs(numerator), Math.abs(denominator));
    }else{
      return "-" + positiveFractionToDecimal(Math.abs(numerator), Math.abs(denominator));
    }
  }

  public static void main(String[] args) {
    System.out.println(new Fraction166().fractionToDecimal(-1, -2147483648));
  }
}
