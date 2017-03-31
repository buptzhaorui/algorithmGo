package com.zr.algorithm.leetcoder.common;

/**
 * User: zhaorui
 * Date: 2017/3/30
 * Time: 14:00
 */
public class Dijkstra {
  int n; //节点个数
  char[] nodes; //节点数组
  int[][] matrix; //邻接矩阵
  static final int INF = Integer.MAX_VALUE;

  void compute(int vs, int[] dist, int[] prev){
    boolean[] flag = new boolean[n];

    for(int i = 0; i < n; i++) {
      dist[i] = matrix[vs][i]; //初始化dist
      prev[i] = vs;
    }

    for(int i = 0; i < n; i++){
      int minIndex = -1, minValue = INF; //从dist中选择最短距离
      for(int k = 0; k < n; k++){
        if(!flag[k] && dist[k] < minValue){
          minIndex = k;
          minValue = dist[k];
        }
      }

      flag[minIndex] = true; //加入解集合

      //更新dist
      for(int k = 0; k < n; k++){
        if(!flag[k] && minValue < dist[k] - matrix[minIndex][k]){
          dist[k] = minValue + matrix[minIndex][k];
          prev[k] = minIndex;
        }
      }
    }
  }
}
