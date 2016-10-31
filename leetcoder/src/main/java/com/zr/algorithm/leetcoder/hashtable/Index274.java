package com.zr.algorithm.leetcoder.hashtable;

import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2016/10/31
 * Time: 14:11
 */
public class Index274 {
  private int hRecursive(int[] sorted, int left, int n) {
    if(left == n){
      return sorted[n-1];
    }else{
      if(n - left <= sorted[left]) return n - left;
      else{
        if(n - sorted[left] >= n || sorted[n - sorted[left]] > sorted[left]) return hRecursive(sorted, left+1, n);
        else return sorted[left];
      }
    }
  }

  public int hIndex(int[] citations) {
    int n = citations.length;
    if(n == 0) return 0;

    Arrays.sort(citations);
    return hRecursive(citations, 0, n);

  }

  //nlogn 排序造成时间的浪费
  public int hIndex2(int[] citations) {
    Arrays.sort(citations);
    int len = citations.length, res = 0;
    for (int citation : citations)
      if(res > len) break;
      else res = Math.max(res, Math.min(citation, len --));
    return res;
  }

  public int hIndex3(int[] citations) {
    int length = citations.length;
    if (length == 0) {
      return 0;
    }

    int[] array2 = new int[length + 1];
    for (int i = 0; i < length; i++) {
      if (citations[i] > length) {
        array2[length] += 1;
      } else {
        array2[citations[i]] += 1;
      }
    }
    int t = 0;
    int result = 0;

    for (int i = length; i >= 0; i--) {
      t = t + array2[i];
      if (t >= i) {
        return i;
      }
    }
    return 0;
  }
}
