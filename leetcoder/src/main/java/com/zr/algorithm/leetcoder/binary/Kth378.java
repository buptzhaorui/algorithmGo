package com.zr.algorithm.leetcoder.binary;

import java.util.PriorityQueue;

/**
 * User: zhaorui
 * Date: 2017/2/6
 * Time: 22:33
 */
public class Kth378 {
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
    for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
    for(int i = 0; i < k-1; i++) {
      Tuple t = pq.poll();
      if(t.x == n-1) continue;
      pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
    }
    return pq.poll().val;
  }

  public int kthSmallest2(int[][] matrix, int k) {
    int m = matrix.length;
    int n = matrix[0].length;

    int lo = matrix[0][0], hi = matrix[m-1][n-1];
    while(lo < hi){
      int mid = (lo + hi) / 2;
      int count = 0;
      for(int i = 0; i < m; i++){
        int j = n-1;
        while(j > 0 && matrix[i][j] > mid) j--;

        count += j+1;
      }
      if(count < k) lo = mid+1;
      else hi = mid;
    }
    return lo;
  }
}

class Tuple implements Comparable<Tuple> {
  int x, y, val;
  public Tuple (int x, int y, int val) {
    this.x = x;
    this.y = y;
    this.val = val;
  }

  @Override
  public int compareTo (Tuple that) {
    return this.val - that.val;
  }
}
