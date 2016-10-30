package com.zr.algorithm.leetcoder.hashtable;

import java.util.HashSet;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 21:12
 */
public class HappyNumber202 {
  private int squareSum(int num) {
    int rst = 0;
    String s = num + "";
    for(char c: s.toCharArray()){
      rst += Math.pow((c - '0'), 2);
    }

    return rst;
  }
  public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    set.add(n);
    int sum = n;
    while(true){
      sum = squareSum(sum);
      System.out.println(sum);
      if(sum == 1) return true;
      else if(!set.add(sum)) return false;
    }
  }
}
