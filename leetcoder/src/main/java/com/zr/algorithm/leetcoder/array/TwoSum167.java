package com.zr.algorithm.leetcoder.array;

/**
 * User: zhaorui
 * Date: 2016/10/19
 * Time: 16:50
 */
public class TwoSum167 {
  public int[] twoSum(int[] numbers, int target) {
    int[] rst = new int[2];
    int left = 0;
    int right = numbers.length - 1;

    while(left < right){
      int v = numbers[left] + numbers[right];
      if(v == target){
        rst[0] = left;
        rst[1] = right;
        break;
      }else if(v > target){
        right --;
      }else{
        left ++;
      }
    }

    return rst;
  }
}
