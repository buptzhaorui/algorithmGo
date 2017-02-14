package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/14
 * Time: 20:41
 */
public class Longest516 {
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];

    for(int i = n-1; i >= 0; i--){
      dp[i][i] = 1;
      for(int j = i+1; j < n; j++){
        if(s.charAt(i) == s.charAt(j)){
          dp[i][j] = dp[i+1][j-1] + 2;
        }else{
          dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        }
      }
    }

    return dp[0][n-1];
  }
}
