package com.zr.algorithm.leetcoder.string;

/**
 * User: zhaorui
 * Date: 2016/12/28
 * Time: 10:49
 */
public class Repeated459 {
  private String construct(int step, String base) {
    if(step == 0) return "";

    return step % 2 == 0 ? construct(step/2, base+base) : base + construct((step-1)/2, base+base);
  }
  public boolean repeatedSubstringPattern(String str) {
    int n = str.length();
    if(n == 0) return false;

    for(int i = 1; i <= n/2; i++){
      if(n % i == 0 && construct(n/i, str.substring(0, i)).equals(str)) return true;
    }
    return false;
  }
}
