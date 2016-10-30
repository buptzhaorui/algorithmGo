package com.zr.algorithm.leetcoder.hashtable;

import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 20:05
 */
public class Valid242 {
  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;
    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();
    Arrays.sort(sArr);
    Arrays.sort(tArr);

    for(int i = 0; i < s.length(); i++){
      if((sArr[i]^tArr[i]) != 0) return false;
    }

    return true;
  }


  public boolean isAnagram2(String s, String t) {
    int[] alphabet = new int[26];
    for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
    for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
    for (int i : alphabet) if (i != 0) return false;
    return true;
  }
}
