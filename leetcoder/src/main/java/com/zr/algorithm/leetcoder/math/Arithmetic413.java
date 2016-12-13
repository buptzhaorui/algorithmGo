package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/13
 * Time: 17:13
 */
public class Arithmetic413 {
  public int numberOfArithmeticSlices(int[] A) {
    int n = A.length;
    if(n < 3) return 0;
    boolean[][] b = new boolean[n][n];
    for(int i = 2; i < n; i++){
      int d = A[i] - A[i-1];
      for(int j = i-2; j >= 0; j--){
        if(A[j+1] - A[j] == d){
          b[j][i] = true;
        }else{
          break;
        }
      }
    }
    int num = 0;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(b[i][j]) num++;
      }
    }

    return num;
  }

  public int numberOfArithmeticSlices2(int[] A) {
    int curr = 0, sum = 0;
    for (int i=2; i<A.length; i++)
      if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
        curr += 1;
        sum += curr;
      } else {
        curr = 0;
      }
    return sum;
  }
}
