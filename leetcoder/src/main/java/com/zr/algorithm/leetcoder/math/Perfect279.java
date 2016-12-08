package com.zr.algorithm.leetcoder.math;

import java.util.*;

/**
 * User: zhaorui
 * Date: 2016/12/7
 * Time: 16:07
 */
public class Perfect279 {
  //dp
  public int numSquares(int n) {
    int[] mins = new int[n+1];
    mins[0] = 0;
    mins[1] = 1;

    for(int i = 2; i <= n; i++){
      mins[i] = Integer.MAX_VALUE;
      for(int j = 1; j*j <= i; j++){
        mins[i] = Math.min(mins[i], mins[i-j*j] + 1);
      }
    }

    return mins[n];
  }

  //BFS
  public int numSquares2(int n) {
    if(n < 2) return n;
    ArrayDeque<Integer> lst = new ArrayDeque<>();
    lst.add(n);
    int depth = 1, m = 1, tmp = 0; //m为当前层所剩活结点，tmp下一层活结点总数
    while(true){
      if(m == 0){ //遍历下一层
        depth ++;
        m = tmp;
        tmp = 0;
      }

      int cur = lst.remove();
      m--;

      int max = (int)Math.sqrt(cur);
      for(int i = max; i > 0; i--){
        int child = cur - i*i;
        if(child == 0) return depth;
        lst.add(child);
        tmp ++;
      }

    }
  }
}
