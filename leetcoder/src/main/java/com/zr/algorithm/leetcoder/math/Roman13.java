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

  public int romanToInt2(String s) {
    int sum=0;
    if(s.indexOf("IV")!=-1){sum-=2;}
    if(s.indexOf("IX")!=-1){sum-=2;}
    if(s.indexOf("XL")!=-1){sum-=20;}
    if(s.indexOf("XC")!=-1){sum-=20;}
    if(s.indexOf("CD")!=-1){sum-=200;}
    if(s.indexOf("CM")!=-1){sum-=200;}

    char c[]=s.toCharArray();
    int count=0;

    for(;count<=s.length()-1;count++){
      if(c[count]=='M') sum+=1000;
      if(c[count]=='D') sum+=500;
      if(c[count]=='C') sum+=100;
      if(c[count]=='L') sum+=50;
      if(c[count]=='X') sum+=10;
      if(c[count]=='V') sum+=5;
      if(c[count]=='I') sum+=1;

    }

    return sum;

  }
}
