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

  public boolean isValidSudoku2(char[][] board) {
    for(int i = 0; i<9; i++){
      HashSet<Character> rows = new HashSet<Character>();
      HashSet<Character> columns = new HashSet<Character>();
      HashSet<Character> cube = new HashSet<Character>();
      for (int j = 0; j < 9;j++){
        if(board[i][j]!='.' && !rows.add(board[i][j]))
          return false;
        if(board[j][i]!='.' && !columns.add(board[j][i]))
          return false;
        int RowIndex = 3*(i/3);
        int ColIndex = 3*(i%3);
        if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
          return false;
      }
    }
    return true;
  }
}
