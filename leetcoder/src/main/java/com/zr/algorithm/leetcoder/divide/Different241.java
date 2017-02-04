package com.zr.algorithm.leetcoder.divide;

import java.util.LinkedList;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2017/2/4
 * Time: 23:23
 */
public class Different241 {
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> rst = new LinkedList<>();

    for(int i = 0; i < input.length(); i++){
      char c = input.charAt(i);
      if(c == '+' || c == '-' || c == '*'){
        List<Integer> rst1 = diffWaysToCompute(input.substring(0, i));
        List<Integer> rst2 = diffWaysToCompute(input.substring(i+1));
        for(int v1: rst1){
          for(int v2: rst2){
            switch (c) {
              case'+':
                rst.add(v1 + v2);
                break;
              case '-':
                rst.add(v1 - v2);
                break;
              case '*':
                rst.add(v1 * v2);
                break;
            }
          }
        }
      }
    }

    if(rst.isEmpty()) rst.add(Integer.valueOf(input));
    return rst;
  }
}
