package com.zr.algorithm.leetcoder.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2016/12/17
 * Time: 14:21
 */
public class Super313 {
  public int nthSuperUglyNumber(int n, int[] primes) {
    if(n == 1) return 1;
    int num = primes.length;
    int[] pointers = new int[num];
    ArrayList<Integer> rst = new ArrayList<>();
    rst.add(1);
    for(int i = 2; i <= n; i++){
      int min = Integer.MAX_VALUE;
      for(int j = 0; j < num; j++){
        min = Math.min(min, rst.get(pointers[j]) * primes[j]);
      }
      rst.add(min);
      for(int j = 0; j < num; j++){
        if(rst.get(pointers[j]) * primes[j] == min) pointers[j]++;
      }
    }
    return rst.get(n-1);
  }

  public int nthSuperUglyNumber2(int n, int[] primes) {
    int[] ugly = new int[n];
    int[] idx = new int[primes.length];
    int[] val = new int[primes.length];
    Arrays.fill(val, 1);

    int next = 1;
    for (int i = 0; i < n; i++) {
      ugly[i] = next;

      next = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        //skip duplicate and avoid extra multiplication
        if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
        //find next ugly number
        next = Math.min(next, val[j]);
      }
    }

    return ugly[n - 1];
  }
}
