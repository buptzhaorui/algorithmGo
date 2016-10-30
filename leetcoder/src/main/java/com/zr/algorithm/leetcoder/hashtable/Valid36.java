package com.zr.algorithm.leetcoder.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * User: zhaorui
 * Date: 2016/10/30
 * Time: 10:25
 */
public class Valid36 {
  public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet<String>();
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
        if(board[i][j] != '.'){
          String b = "(" + board[i][j] + ")";
          if(!seen.add(i + b) || !seen.add(b + j) || !seen.add(i/3 + b + j/3))
            return false;
        }
      }
    }
    return true;
  }
}
