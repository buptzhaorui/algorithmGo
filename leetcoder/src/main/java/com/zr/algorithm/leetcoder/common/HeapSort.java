package com.zr.algorithm.leetcoder.common;

/**
 * User: zhaorui
 * Date: 2017/3/21
 * Time: 13:20
 */
public class HeapSort { // min heap
  // 2i+1 2i+2
  void adjust(int[] arr, int i, int n){
    int j = i;
    if(2*i+1 < n && arr[2*i+1] < arr[j]) j = 2*i+1;
    if(2*i+2 < n && arr[2*i+2] < arr[j]) j = 2*i+2;
    if(arr[i] > arr[j]){
      swap(arr, i, j);
      adjust(arr, j, n);
    }
  }

  void swap(int[] arr, int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  void heapSort(int[] arr){
    int n = arr.length;
    //build heap
    for(int i = n-1; i >= 0; i--){
      adjust(arr, i, n);
    }

    //sort heap
    for(int k = 0; k < n-1; k++){
      swap(arr, 0, n-1-k);
      adjust(arr, 0, n-1-k);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[]{3,4,6,2,5,2,0,34,3};
    new HeapSort().heapSort(arr);
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
}
