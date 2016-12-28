package com.zr.algorithm.leetcoder.string;

/**
 * User: zhaorui
 * Date: 2016/12/28
 * Time: 14:14
 */
public class ZigZag6 {
  public String convert(String s, int numRows) {
    if(numRows == 1) return s;

    StringBuilder[] sbs = new StringBuilder[numRows];
    for(int i = 0; i < numRows; i++){
      sbs[i] = new StringBuilder();
    }

    int base1 = 2*(numRows-1), base2 = numRows-1;
    for(int i = 0; i < s.length(); i++){
      int v1 = i % base1;
      if(v1 < numRows){
        sbs[v1].append(s.charAt(i));
      }else{
        sbs[(base1 - v1) % base2].append(s.charAt(i));
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < numRows; i++){
      sb.append(sbs[i].toString());
    }

    return sb.toString();
  }
}
