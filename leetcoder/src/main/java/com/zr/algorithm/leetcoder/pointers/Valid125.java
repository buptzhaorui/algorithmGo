package com.zr.algorithm.leetcoder.pointers;

/**
 * User: zhaorui
 * Date: 2016/12/19
 * Time: 21:31
 */
public class Valid125 {
  public boolean isPalindrome(String s) {
    s = s.replaceAll("^w", "");
    int left = 0;
    int right = s.length() - 1;
    while(left < right){
      char c1 = s.charAt(left++);
      char c2 = s.charAt(right--);
      if(c1 >= '0' && c1 <= '9'){
        if(c1 != c2) return false;
      }else{
        if(!(c1 == c2 || c1 - c2 == 0 || c1 - c2 == 32 || c1 - c2 == -32)) return false;
      }
    }
    return true;
  }
}
