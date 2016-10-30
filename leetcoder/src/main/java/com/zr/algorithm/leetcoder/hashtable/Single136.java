package com.zr.algorithm.leetcoder.hashtable;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 20:02
 */
public class Single136 {
  public int singleNumber(int[] nums) {
    int rst = 0;
    for(int num: nums)
      rst ^= num;
    return rst;
  }
}
