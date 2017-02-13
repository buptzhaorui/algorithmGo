package com.zr.algorithm.leetcoder.dp;

import java.util.List;

/**
 * User: zhaorui
 * Date: 2017/2/13
 * Time: 21:21
 */
public class Word139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n+1];
    dp[0] = true;

    for(int i = 1; i <= n; i++){
      for(int j = 0; j < i; j++){
        if(dp[j] && wordDict.contains(s.substring(j, i))){
          dp[i] = true;
          break;
        }
      }
    }

    return dp[n];
  }
}
