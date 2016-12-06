package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/6
 * Time: 15:18
 */
public class Excel168 {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while(n != 0){
      int v = (n-1) % 26;
      sb.insert(0, (char)('A' + v));
      n = (n-1) / 26;
    }
    return sb.toString();
  }
}
