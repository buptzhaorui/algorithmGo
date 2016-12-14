package com.zr.algorithm.leetcoder.math;

import java.util.ArrayList;

/**
 * User: zhaorui
 * Date: 2016/12/14
 * Time: 19:57
 */
public class Permutation60 {
  private void permutation(boolean[] b, ArrayList<String> rst, String prefix, int n, int l, int k){
    if(rst.size() == k) return;
    if(l > n){
      rst.add(prefix);
      return;
    }
    for(int i = 0; i < b.length; i++){
      if(!b[i]){
        b[i] = true;
        permutation(b, rst, prefix + (i+1), n, l+1, k);
        b[i] = false;
      }
    }
  }
  public String getPermutation(int n, int k) {
    boolean[] b = new boolean[n];
    ArrayList<String> rst = new ArrayList<>();
    permutation(b, rst, "", n, 1, k);
    return rst.get(k-1);
  }

  public String getPermutation2(int n, int k){
    int[] factorial = new int[n];
    factorial[0] = 1;

    for(int i = 1; i < n; i++) {
      factorial[i] = factorial[i-1] * i;
    }

    ArrayList<Integer> numbers = new ArrayList<>();
    for(int i = 1; i <= n; i++) {
      numbers.add(i);
    }

    String res = "";
    for(int i = n-1; i >= 0; i--) {

      int num = (k-1)/factorial[i];
      res += numbers.get(num);
      k -= num * factorial[i];
      numbers.remove(num);
    }

    return res;
  }
}
