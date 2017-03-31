package com.zr.algorithm.leetcoder.binary;

/**
 * User: zhaorui
 * Date: 2017/3/27
 * Time: 13:04
 */
public class RotateMin {
  int findMin(int[] arr){
    int n = arr.length;
    int left = 0, right = n-1;
    while(arr[left] >= arr[right] && left < right){
      int mid = (left + right) / 2;
      if(arr[left] < arr[mid]){
        left = mid + 1;
      }else if(arr[left] == arr[mid]){
        left ++;
      }else{
        right = mid;
      }
    }

    return arr[left];
  }


  public static void main(String[] args){
    System.out.println(new RotateMin().findMin(new int[]{1}));
  }
}
