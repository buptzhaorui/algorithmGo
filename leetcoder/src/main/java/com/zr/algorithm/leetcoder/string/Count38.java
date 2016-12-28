package com.zr.algorithm.leetcoder.string;

/**
 * User: zhaorui
 * Date: 2016/12/28
 * Time: 21:09
 */
public class Count38 {
  public String countAndSay(int n) {
    if(n == 1) return "1";
    String rst = "1";
    while(n > 1){
      int index = 0;
      int count = 1;
      StringBuilder sb = new StringBuilder();
      int l = rst.length();
      while(index < l){
        while(index + 1 < l && rst.charAt(index) == rst.charAt(index+1)) {count++;index++;}
        sb.append(count);
        sb.append(rst.charAt(index));
        index++;
        count = 1;
      }
      rst = sb.toString();
      System.out.println(rst);
      n--;
    }
    return rst;
  }
}
