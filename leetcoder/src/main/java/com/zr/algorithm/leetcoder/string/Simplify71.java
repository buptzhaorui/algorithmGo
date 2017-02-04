package com.zr.algorithm.leetcoder.string;

import java.util.Stack;

/**
 * User: zhaorui
 * Date: 2017/2/4
 * Time: 14:55
 */
public class Simplify71 {
  public String simplifyPath(String path) {
    String[] direcs = path.split("/");
    Stack<String> stack = new Stack<>();

    for(String direc: direcs){
      if(direc.length() > 0){
        if(direc.equals(".")){

        }else if(direc.equals("..")){
          if(!stack.empty()) stack.pop();
        }else{
          stack.push(direc);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while(!stack.empty()){
      sb.insert(0, stack.pop());
      sb.insert(0, "/");
    }

    return sb.length() == 0 ? "/" : sb.toString();
  }
}
