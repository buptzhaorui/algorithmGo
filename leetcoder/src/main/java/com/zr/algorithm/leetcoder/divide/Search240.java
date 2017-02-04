package com.zr.algorithm.leetcoder.divide;

/**
 * User: zhaorui
 * Date: 2017/2/4
 * Time: 16:40
 */
public class Search240 {
  private boolean recursive(int[][] matrix, int target, int left, int right, int up, int down){
    if(left > right || up > down) return false;
    else if(left == right && up == down && matrix[up][left] == target) return true;
    else{
      int mid1 = (left + right) / 2;
      int mid2 = (up + down) / 2;
      if(matrix[mid2][mid1] == target)
        return true;
      else if(matrix[mid2][mid1] > target)
        return recursive(matrix, target, left, mid1-1, up, down) ||
          recursive(matrix, target, mid1, right, up, mid2-1);
      else
        return recursive(matrix, target, mid1+1, right, up, down) ||
          recursive(matrix, target, left, mid1, mid2+1, down);
    }
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    if(rows == 0) return false;
    int cols = matrix[0].length;

    return recursive(matrix, target, 0, cols-1, 0, rows-1);
  }
}
