package com.zr.algorithm.leetcoder.pointers;

/**
 * User: zhaorui
 * Date: 2016/12/21
 * Time: 13:00
 */
public class Implement28 {
  public int strStr1(String haystack, String needle){
    int h = haystack.length();
    int n = needle.length();
    for(int i = 0; ; i++){
      if(i + n > h) return -1;
      for(int j = 0; ; j++){
        if(j == n) return i;
        if(haystack.charAt(i+j) != needle.charAt(j)) break;
      }
    }
  }

  private int[] genNext(String needle) {
    int n = needle.length();
    int[] next = new int[n];
    next[0] = -1;
    for(int i = 0, j = -1; i < n-1;){
      if(j == -1 || needle.charAt(i) == needle.charAt(j)){
        if(needle.charAt(++i) == needle.charAt(++j)){
          next[i] = next[j];
        }else{
          next[i] = j;
        }
      }else{
        j = next[j];
      }
    }

    return next;
  }

  public int strStr2(String haystack, String needle) {
    if(needle.equals("")) return 0;
    if(haystack.equals("")) return -1;

    int[] next = genNext(needle);
    for(int i = 0, j = 0; i < haystack.length();){
      if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
        i++; j++;
        if(j == needle.length()) return i-j;
      }
    }
  }
}

