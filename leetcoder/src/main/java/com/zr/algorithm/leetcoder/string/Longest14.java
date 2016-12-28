package com.zr.algorithm.leetcoder.string;

/**
 * User: zhaorui
 * Date: 2016/12/28
 * Time: 16:51
 */
public class Longest14 {
  public String longestCommonPrefix(String[] strs) {
    int n = strs.length;
    if(n == 0) return "";
    if(n == 1) return strs[0];
    int i = 0;
    StringBuilder sb = new StringBuilder();
    while(i < strs[0].length()){
      for(int j = 1; j < n; j++){
        if(strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) return sb.toString();
      }
      sb.append(strs[0].charAt(i++));
    }
    return sb.toString();
  }
}
