package com.zr.algorithm.leetcoder.binary;

/**
 * User: zhaorui
 * Date: 2017/2/8
 * Time: 13:53
 */
public class Is392 {
  public boolean isSubsequence(String s, String t) {
    if(s.length()==0) return true;
    int i = 0;
    int len = t.length();
    for(char ss: s.toCharArray()){
      while(i < len && ss != t.charAt(i)){
        i++;
      }
      i++;
    }

    return i <= len;
  }
}
