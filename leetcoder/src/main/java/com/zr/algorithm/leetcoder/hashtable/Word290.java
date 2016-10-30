package com.zr.algorithm.leetcoder.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 19:34
 */
public class Word290 {
  public boolean wordPattern(String pattern, String str) {
    String[] arr = str.split(" ");
    int n = pattern.length();
    if(n != arr.length) return false;

    HashMap<Character, String> map = new HashMap<>();
    for(int i = 0; i < n; i++){
      char c = pattern.charAt(i);
      String value = map.get(c);
      if(value == null && !map.containsValue(arr[i])) map.put(c, arr[i]);
      else if(value != null && value.equals(arr[i])) ;
      else return false;
    }
    return true;
  }
}
