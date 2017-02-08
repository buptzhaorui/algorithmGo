package com.zr.algorithm.leetcoder.binary;

import java.util.Arrays;
import java.util.HashMap;

/**
 * User: zhaorui
 * Date: 2017/2/7
 * Time: 15:01
 */
public class Sum454 {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int a: A){
      for(int b: B){
        map.put(a+b, map.getOrDefault(a+b, 0)+1);
      }
    }

    int rst = 0;

    for(int c: C){
      for(int d: D){
        rst += map.getOrDefault(-(c+d), 0);
      }
    }

    return rst;
  }
}
