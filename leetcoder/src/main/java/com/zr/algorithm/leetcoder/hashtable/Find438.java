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
    for (int i = 0; i <= s.length() - length; i++) {
      if (isAnagram2(s, p, i, length)) rst.add(i);
    }
    return rst;
  }


  public List<Integer> findAnagrams2(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
      hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
      //move right everytime, if the character exists in p's hash, decrease the count
      //current hash value >= 1 means the character is existing in p
      if (hash[s.charAt(right++)]-- >= 1) count--;

      //when the count is down to 0, means we found the right anagram
      //then add window's left to result list
      if (count == 0) list.add(left);

      //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
      //++ to reset the hash because we kicked out the left
      //only increase the count if the character is in p
      //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
      if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    }
    return list;
  }
}