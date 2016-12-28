package com.zr.algorithm.leetcoder.string;

/**
 * User: zhaorui
 * Date: 2016/12/28
 * Time: 17:43
 */
public class Number434 {
  public int countSegments(String s) {
    return s.equals("") ? 0 : s.split(" ").length;
  }
}
