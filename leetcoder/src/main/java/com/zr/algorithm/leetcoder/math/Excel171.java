package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/6
 * Time: 16:02
 */
public class Excel171 {
  public int titleToNumber(String s) {
    int rst = 0;
    for(char c: s.toCharArray()){
      rst = rst * 26 + c - 'A' + 1;
    }
    return rst;
  }
}
