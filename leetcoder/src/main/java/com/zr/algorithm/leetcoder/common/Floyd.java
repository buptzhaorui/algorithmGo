package com.zr.algorithm.leetcoder.common;

/**
 * User: zhaorui
 * Date: 2017/3/31
 * Time: 14:11
 */
public class Floyd {
  int n; //节点个数
  char[] nodes; //节点数组
  int[][] matrix; //邻接矩阵
  static final int INF = Integer.MAX_VALUE;

  void compute(int[][] dist, int[][] path){
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        dist[i][j] = matrix[i][j];
        path[i][j] = j; //最短路径经过j，下一跳
      }
    }

    for(int k = 0; k < n; k++){
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          if(dist[i][k] < dist[i][j] - dist[k][j]){
            dist[i][j] = dist[i][k] + dist[k][j];
            path[i][j] = path[i][k];
          }
        }
      }
    }
  }
}
