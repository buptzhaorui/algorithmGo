package com.zr.algorithm.leetcoder.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 22:31
 */
public class Find438 {
  public boolean isAnagram2(String s, String p, int start, int length) {
    int[] alphabet = new int[26];
    for (int i = start; i < start + length; i++) alphabet[s.charAt(i) - 'a']++;
    for (int i = 0; i < length; i++) alphabet[p.charAt(i) - 'a']--;
    for (int i : alphabet) if (i != 0) return false;
    return true;
  }
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> rst = new ArrayList<>();
    int length = p.length();
    for(int i = 0; i <= s.length() - length; i++){
      if(isAnagram2(s, p, i, length)) rst.add(i);
    }
    return rst;
  }
}
