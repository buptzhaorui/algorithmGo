package com.zr.algorithm.leetcoder.math;

import java.util.HashMap;

/**
 * User: zhaorui
 * Date: 2016/12/4
 * Time: 17:03
 */
public class Roman13 {
  public int romanToInt(String s) {
//    HashMap<Character, Integer> map = new HashMap<>();
//    map.put('I', 1);
//    map.put('V', 5);
//    map.put('X', 10);
//    map.put('L', 50);
//    map.put('C', 100);
//    map.put('D', 500);
//    map.put('M', 1000);

    int num = 0;
    char[] arr = s.toCharArray();
    int i = 0, n = arr.length;
    while(i < n){
      char c = arr[i];
      switch (c) {
        case 'I':
          if(i+1 < n && (arr[i+1] == 'V' || arr[i+1] == 'X')){
            num -= 1;
          }else{
            num += 1;
          }
          break;
        case 'V':
          num += 5;
          break;
        case 'X':
          if(i+1 < n && (arr[i+1] == 'L' || arr[i+1] == 'C')){
            num -= 10;
          }else{
            num += 10;
          }
          break;
        case 'L':
          num += 50;
          break;
        case 'C':
          if(i+1 < n && (arr[i+1] == 'D' || arr[i+1] == 'M')){
            num -= 100;
          }else{
            num += 100;
          }
          break;
        case 'D':
          num += 500;
          break;
        case 'M':
          num += 1000;
          break;
      }
      i++;
    }

    return num;
  }
}
