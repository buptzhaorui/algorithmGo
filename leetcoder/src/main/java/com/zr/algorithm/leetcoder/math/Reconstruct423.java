package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/8
 * Time: 15:53
 */
public class Reconstruct423 {
  public String originalDigits(String s) {
    int[] count = new int[10];
    for(char c: s.toCharArray()){
      switch (c){
        case 'z':
          count[0]++; break;
        case 'w':
          count[2]++; break;
        case 'u':
          count[4]++; break;
        case 'x':
          count[6]++; break;
        case 'g':
          count[8]++; break;
        case 'o':
          count[1]++; break;
        case 't':
          count[3]++; break;
        case 'f':
          count[5]++; break;
        case 's':
          count[7]++; break;
        case 'i':
          count[9]++; break;
      }
    }

    count[1] -= count[0] + count[2] + count[4];
    count[3] -= count[2] + count[8];
    count[5] -= count[4];
    count[7] -= count[6];
    count[9] -= count[5] + count[6] + count[8];

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i <= 9; i++){
      for(int j = 1; j <= count[i]; j++){
        sb.append(i);
      }
    }

    return sb.toString();
  }
}
