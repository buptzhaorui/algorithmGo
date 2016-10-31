package com.zr.algorithm.leetcoder.hashtable;

import java.util.HashMap;

/**
 * User: zhaorui
 * Date: 2016/10/31
 * Time: 18:41
 */
public class Longest3 {
  //abcabcbb
  public int lengthOfLongestSubstring(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;
    int left, right, rst, counter;
    left = right = rst = counter = 0;

    HashMap<Character, Integer> map = new HashMap<>();
    while(right < n){
      char c = chars[right];
      Integer origin = map.get(c);
      if(origin == null || origin < left){
        counter ++;
      }else{
        left = origin + 1;
        counter = right - left + 1;
      }
      rst = Math.max(rst, counter);
      map.put(c, right);
      right++;
    }
    return rst;
  }
}
