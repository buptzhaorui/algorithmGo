package com.zr.algorithm.leetcoder.string;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * User: zhaorui
 * Date: 2016/12/28
 * Time: 17:43
 */
public class Number434 {
  public int countSegments(String s) {
    Stream<String> stream = Arrays.stream(s.split("\\s+"));
    return (int)stream.filter( a -> a.length() > 0).count();
  }

  public int countSegments2(String s) {
    int res=0;
    for(int i=0; i<s.length(); i++)
      if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
        res++;
    return res;
  }
}
