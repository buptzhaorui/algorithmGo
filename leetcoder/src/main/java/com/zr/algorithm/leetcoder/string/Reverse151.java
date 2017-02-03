package com.zr.algorithm.leetcoder.string;

/**
 * User: zhaorui
 * Date: 2017/2/3
 * Time: 15:52
 */
public class Reverse151 {
  public String reverseWords(String s) {
    String[] parts = s.trim().split("\\s+");
    String out = "";
    for (int i = parts.length - 1; i > 0; i--) {
      out += parts[i] + " ";
    }
    return out + parts[0];
  }

  public static void main(String[] args){
    Reverse151 r = new Reverse151();
    System.out.println(r.reverseWords(" 1")+"#");
  }
}
