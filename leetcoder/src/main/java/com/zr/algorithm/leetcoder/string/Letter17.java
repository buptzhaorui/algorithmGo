package com.zr.algorithm.leetcoder.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2017/2/3
 * Time: 21:41
 */
public class Letter17 {
  private void recursive(HashMap<Integer, List<Character>> map, String digits, int index, List<String> rst, String cur){
    if(digits.length() == index) {rst.add(cur);return;}

    int digit = digits.charAt(index) - '0';
    for( char c : map.get(digit)){
      recursive(map, digits, index+1, rst, cur+c);
    }

  }
  public List<String> letterCombinations(String digits) {
    HashMap<Integer, List<Character>> map = new HashMap<>();
    map.put(2, Arrays.asList('a', 'b', 'c'));
    map.put(3, Arrays.asList('d', 'e', 'f'));
    map.put(4, Arrays.asList('g', 'h', 'i'));
    map.put(5, Arrays.asList('j', 'k', 'l'));
    map.put(6, Arrays.asList('m', 'n', 'o'));
    map.put(7, Arrays.asList('p', 'q', 'r', 's'));
    map.put(8, Arrays.asList('t', 'u', 'v'));
    map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

    ArrayList<String> rst = new ArrayList<>();
    if(digits.length()==0 ||digits.contains("0") || digits.contains("1")) return rst;
    recursive(map, digits, 0, rst, "");

    return rst;
  }
}
