package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/17
 * Time: 10:10
 */
public class Integer12 {
  public String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();

    int m = num / 1000;
    for(int i = 0; i < m; i++) sb.append("M");

    num = num % 1000;

    int c = num / 100;
    if(c == 9){
      sb.append("CM");
    }else if(c == 4){
      sb.append("CD");
    }else if(c >= 5){
      sb.append("D");
      for (int i = 0; i < c-5; i++) sb.append("C");
    }else{
      for (int i = 0; i < c; i++) sb.append("C");
    }

    num = num % 100;

    int x = num / 10;
    if(x == 9){
      sb.append("XC");
    }else if(x == 4){
      sb.append("XL");
    }else if(x >= 5){
      sb.append("L");
      for (int i = 0; i < x-5; i++) sb.append("X");
    }else{
      for (int i = 0; i < x; i++) sb.append("X");
    }

    num = num % 10;

    int i = num;
    if(i == 9){
      sb.append("IX");
    }else if(i == 4){
      sb.append("IV");
    }else if(i >= 5){
      sb.append("V");
      for (int j = 0; j < i-5; j++) sb.append("I");
    }else{
      for (int j = 0; j < i; j++) sb.append("I");
    }

    return sb.toString();
  }
}
