package com.zr.algorithm.leetcoder.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2016/11/4
 * Time: 21:23
 */
public class Group49 {
  private String toUnicode(String s) {
    int[] freq = new int[26];
    StringBuilder sb = new StringBuilder();
    for(char c: s.toCharArray()){
      freq[c - 'a'] += 1;
    }
    for(int f: freq){
      sb.append(f);
    }
    return sb.toString();
  }
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> rst = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    for(String s: strs){
      String code = toUnicode(s);
      List<String> oldList = map.get(code);
      if(oldList == null){
        List<String> newList = new ArrayList<>();
        newList.add(s);
        map.put(code, newList);
        rst.add(newList);
      }else{
        oldList.add(s);
      }
    }

    return rst;
  }
}
