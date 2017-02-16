package com.zr.algorithm.leetcoder.dp;

/**
 * User: zhaorui
 * Date: 2017/2/15
 * Time: 16:53
 */
public class Best309 {
  public int maxProfit(int[] prices) {
    int sell = 0,
      prevSell = 0,
      buy = Integer.MIN_VALUE;
    for(int price: prices){
      int curSell = Math.max(buy + price, sell);
      int curBuy = Math.max(prevSell - price, buy);
      prevSell = sell;
      sell = curSell;
      buy = curBuy;
    }

    return sell;
  }
}
