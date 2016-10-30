package com.zr.algorithm.leetcoder.hashtable;

import java.util.HashMap;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 20:50
 */
public class Isomorphic205 {
  public boolean isIsomorphic(String s, String t) {
    HashMap<Character, Character> map = new HashMap<>();
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      Character value = map.get(c);
      if(value == null && !map.containsValue(t.charAt(i))) map.put(c, t.charAt(i));
      else if(value != null && value.equals(t.charAt(i))) ;
      else return false;
    }
    return true;
  }
}
