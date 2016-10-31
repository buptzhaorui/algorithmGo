package com.zr.algorithm.leetcoder.hashtable;

import java.util.*;

/**
 * User: zhaorui
 * Date: 2016/10/31
 * Time: 19:17
 */
public class Repeated187 {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> rst = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    int n = s.length();

    for(int i = 0; i <= n-10; i++){
      String sub = s.substring(i, i+10);
      Integer origin = map.get(sub);
      if(origin == null){
        map.put(sub, 1);
      }else if(origin == 1){
        map.put(sub, 2);
        rst.add(sub);
      }else{
        map.put(sub, origin+1);
      }
    }

    return rst;
  }

  public List<String> findRepeatedDnaSequences2(String s) { //看成4进制数字
    Set<Integer> words = new HashSet<>();
    Set<Integer> doubleWords = new HashSet<>();
    List<String> rv = new ArrayList<>();
    char[] map = new char[26];
    //map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;

    for(int i = 0; i < s.length() - 9; i++) {
      int v = 0;
      for(int j = i; j < i + 10; j++) {
        v <<= 2;
        v |= map[s.charAt(j) - 'A'];
      }
      if(!words.add(v) && doubleWords.add(v)) {
        rv.add(s.substring(i, i + 10));
      }
    }
    return rv;
  }
}
