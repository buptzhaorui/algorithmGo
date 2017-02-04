package com.zr.algorithm.leetcoder.string;

/**
 * User: zhaorui
 * Date: 2017/2/3
 * Time: 23:17
 */
public class Decode91 {
  public int numDecodings(String s) {
    int n = s.length();
    if(n == 0 || s.startsWith("0") || s.contains("00"))return 0;
    int[] rst = new int[n+1];
    rst[0] = rst[1] = 1;
    for(int i = 2; i <= n; i++){
      char c1 = s.charAt(i-2);
      char c2 = s.charAt(i-1);
      int cur = (c1 - '0') * 10 + (c2 - '0');
      if(c1 != '0' && cur <= 26 && c2 != '0'){
        rst[i] = rst[i-1] + rst[i-2];
      }else if(cur > 26 && c2 != '0' || cur <= 26 && c1 == '0'){
        rst[i] = rst[i-1];
      }else if(cur <= 26 && s.charAt(i-1) == '0'){
        rst[i] = rst[i-2];
      }else{
        return 0;
      }

    }
    return rst[n];
  }

  public int numDecodings2(String s) {
    int n = s.length();
    if (n == 0) return 0;

    int[] memo = new int[n+1];
    memo[n]  = 1;
    memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

    for (int i = n - 2; i >= 0; i--)
      if (s.charAt(i) == '0') continue;
      else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

    return memo[0];
  }
}

