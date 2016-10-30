package com.zr.algorithm.leetcoder.hashtable;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 9:22
 */
public class Longest409 {
  public int longestPalindrome(String s) {
    int rst = 0;
    int n = s.length();
    int[] tmp = new int[256];
    for(int i = 0; i < n; i++){
      int value = tmp[s.charAt(i)] ^ 1;
      if(value == 0){
        rst ++;
      }
      tmp[s.charAt(i)] = value;
    }

    rst *= 2;
    if(rst < n) rst ++;

    return rst;
  }

  public int longestPalindrome2(String s) {
    if (s == null || s.length() == 0) return 0;
    if (s.length() == 1) return 1;

    int result = 0;
    int[] counter = new int[128];

    for (char c : s.toCharArray()) {
      if(counter[c] == 0) {
        counter[c] = 1;
      } else {
        counter[c] = 0;
        result += 2;
      }
    }

    return Math.min(result + 1, s.length());
  }
}
