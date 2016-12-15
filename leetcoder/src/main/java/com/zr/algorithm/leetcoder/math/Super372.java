package com.zr.algorithm.leetcoder.math;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2016/12/14
 * Time: 21:27
 */
public class Super372 {
  private int powMod(int a, int k){
    a %= 1337;
    int rst = 1;
    for(int i = 0; i < k; i++){
      rst = rst * a % 1337;
    }
    return rst;
  }

  private int powHelper(int a, int[] b, int length){
    if(length == -1) return 1;
    return powMod(powHelper(a, b, length - 1), 10) * powMod(a, b[length]) % 1337;
  }
  public int superPow(int a, int[] b) {
    return powHelper(a, b, b.length-1);
  }




  int DIV = 1337;

  List<Integer> findLoop(int a){
    List<Integer> index = new ArrayList<>();
    boolean[] set = new boolean[DIV];
    int rem = a % DIV;
    while ( ! set[rem] ) {
      set[rem]=true;
      index.add(rem);
      rem = (rem*a) % DIV;
    }
    return index;
  }

  int modBy(int[] b, int m){
    int rem = 0;
    for (int i=0; i < b.length; i++) {
      rem = (rem*10+b[i]) % m;
    }
    return rem;
  }

  public int superPow2(int a, int[] b) {
    if (a==0 || a==DIV || b==null || b.length == 0) return 0;
    if (a==1) return 1;
    if (a > DIV) return superPow2( a % DIV, b);
    List<Integer> index = findLoop(a);
    int loopsize = index.size();
    int rem = modBy(b, loopsize);
    rem = rem==0? loopsize: rem;
    return index.get(rem-1);
  }
}
