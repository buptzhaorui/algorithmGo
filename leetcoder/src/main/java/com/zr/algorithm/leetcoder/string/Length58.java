package com.zr.algorithm.leetcoder.string;

import java.util.Arrays;


/**
 * User: zhaorui
 * Date: 2016/12/29
 * Time: 14:44
 */
public class Length58 {
  public int lengthOfLastWord(String s) {
    Object[] arr = Arrays.stream(s.split("\\s+")).filter( w -> w.length() > 0).toArray();
    if(arr.length == 0) return 0;
    return ((String)arr[arr.length-1]).length();
  }

  public int lengthOfLastWord2(String s) {
    int len = 0, tail = s.length() - 1;
    while (tail >= 0 && s.charAt(tail) == ' ') tail--;
    while (tail >= 0 && s.charAt(tail) != ' ') {
      len++;
      tail--;
    }
    return len;
  }
}
