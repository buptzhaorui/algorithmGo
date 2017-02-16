package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/16
 * Time: 12:50
 */
public class Range304 {
  int[][] dp = null;

  public Range304(int[][] matrix) {
    int rows = matrix.length;
    if(rows == 0) return;
    int cols = matrix[0].length;
    if(cols == 0) return;

    dp = matrix;

    for(int i = 1; i < rows; i++){
      dp[i][0] += dp[i-1][0];
    }

    for(int j = 1; j < cols; j++){
      dp[0][j] += dp[0][j-1];
    }

    for(int i = 1; i < rows; i++){
      for(int j = 1; j < cols; j++){
        dp[i][j] += dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if(dp == null) return 0;
    if(row1 == 0){
      if(col1 == 0){
        return dp[row2][col2];
      }else{
        return dp[row2][col2] - dp[row2][col1-1];
      }
    }else{
      if(col1 == 0){
        return dp[row2][col2] - dp[row1-1][col2];
      }else{
        return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1-1][col1-1];
      }
    }
  }
}
