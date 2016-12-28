package com.zr.algorithm.leetcoder.string;

/**
 * User: zhaorui
 * Date: 2016/12/28
 * Time: 16:06
 */
public class Ransom383 {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] tmp = new int[256];
    for(char c: ransomNote.toCharArray()){
      tmp[c] ++;
    }

    for(char c: magazine.toCharArray()){
      tmp[c] --;
    }

    for(int i = 0; i < 256; i++){
      if(tmp[i] > 0) return false;
    }

    return true;
  }
}
