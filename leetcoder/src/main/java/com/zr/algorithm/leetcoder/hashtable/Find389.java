package com.zr.algorithm.leetcoder.hashtable;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 19:19
 */
public class Find389 {
  public char findTheDifference(String s, String t) {
    int rst = 0;
    for(char c: s.toCharArray()){
      rst ^= (int)c;
    }
    for(char c: t.toCharArray()){
      rst ^= (int)c;
    }

    return (char)rst;
  }

  public char findTheDifference2(String s, String t) {
    int i = 0, res = 0;

    for (i = 0; i < s.length(); i++) {
      res ^= s.charAt(i) ^ t.charAt(i);
    }

    return (char)(res ^ t.charAt(i));
  }
}
