package com.zr.algorithm.leetcoder.common;

/**
 * User: zhaorui
 * Date: 2017/3/21
 * Time: 11:25
 */
public class KMP {
  int[] getNext(String p){
    int n = p.length();
    int[] next = new int[n];
    int j = 0, k = -1;
    next[j] = k;
    while(j < n-1){
      if(k == -1 || p.charAt(j) == p.charAt(k)){
        next[++j] = ++k;
      }else{
        k = next[k];
      }
    }
    return next;
  }

  int kmpIndex(String s, String p, int[] next){
    int nt = s.length();
    int np = p.length();
    int i = 0, j = 0;
    while(i < nt && j < np){
      System.out.println(i + " " + j);
      if(j == -1 || s.charAt(i) == p.charAt(j)){
        i++;
        j++;
      }else{
        j = next[j];
      }
    }

    if(j == np) return i - j;
    else return -1;
  }
  public int strStr(String haystack, String needle) {
    if(needle.length() == 0) return 0;
    int[] next = getNext(needle);
    for(int i = 0; i < needle.length(); i++)
      System.out.println(next[i]);
    return kmpIndex(haystack, needle, next);
  }
}
