package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/9
 * Time: 22:34
 */
public class Ones474 {
  private int totalNum(String s, char c){
    int rst = 0;
    for(char c1: s.toCharArray()){
      if(c1 == c) rst++;
    }
    return rst;
  }

  public int findMaxForm(String[] strs, int m, int n) {
    int rst = 0;
    int[][] dp = new int[m+1][n+1];

    for(String s: strs){
      int m1 = totalNum(s, '0');
      int n1 = totalNum(s, '1');

      for(int i = m1; i <= m; i++){
        for(int j = n1; j <= n; j++){
          dp[i - m1][j - n1] = Math.max(dp[i - m1][j - n1], dp[i][j] + 1);
          rst = Math.max(rst, dp[i - m1][j - n1]);
        }
      }
    }
    return rst;
  }
}
