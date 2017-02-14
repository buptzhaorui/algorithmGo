package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/14
 * Time: 13:27
 */
public class Coin322 {
  private int minCoin(int[] coins){
    int min = Integer.MAX_VALUE;
    for(int coin: coins){
      min = Math.min(min, coin);
    }
    return min;
  }
  public int coinChange(int[] coins, int amount) {
    if(amount == 0) return 0;
    if(coins.length == 0) return -1;
    int min = minCoin(coins);
    if(amount < min) return -1;
    if(amount == min) return 1;

    int[] dp = new int[amount+1];
    for(int i = 1; i < min; i++){
      dp[i] = -1;
    }

    for(int i = min; i <= amount; i++){
      for(int coin: coins){
        if(coin <= i){
          if(dp[i] > 0){
            if(dp[i-coin] >= 0){
              dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
          }else{
            if(dp[i-coin] >= 0){
              dp[i] = dp[i-coin] + 1;
            }else{
              dp[i] = -1;
            }
          }
        }
      }
    }

    return dp[amount];
  }
}
