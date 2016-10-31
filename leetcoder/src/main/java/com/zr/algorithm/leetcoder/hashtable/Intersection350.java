package com.zr.algorithm.leetcoder.hashtable;

import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2016/10/31
 * Time: 13:29
 */
public class Intersection350 {
  public int[] intersect(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;
    int[] rst = new int[n1 > n2 ? n2 : n1];
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int i, i1, i2;
    i = i1 = i2 = 0;

    while(i1 < n1 && i2 < n2){
      if(nums1[i1] == nums2[i2]){
        rst[i++] = nums1[i1];
        i1 ++;
        i2 ++;
      }else if(nums1[i1] < nums2[i2]){
        i1 ++;
      }else{
        i2 ++;
      }

    }

    int[] num = new int[i];
    System.arraycopy(rst, 0, num, 0, i);
    return num;
  }
}
