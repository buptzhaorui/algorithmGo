package com.zr.algorithm.leetcoder.divide;

/**
 * User: zhaorui
 * Date: 2017/2/4
 * Time: 19:49
 */
public class Kth215 {
  private void adjustHeap(int[] nums, int index, int size){
    int left = index * 2 + 1;
    int right = left + 1;

    int lagest = index;
    if(left < size && nums[left] > nums[lagest]){
      lagest = left;
    }
    if(right < size && nums[right] > nums[lagest]){
      lagest = right;
    }

    if(lagest != index){
      int tmp = nums[index];
      nums[index] = nums[lagest];
      nums[lagest] = tmp;
      adjustHeap(nums, lagest, size);
    }
  }

  public int findKthLargest(int[] nums, int k) {
    int n = nums.length - 1;
    //init heap
    for(int i = (n-1) / 2; i >= 0; i--){
      adjustHeap(nums, i, n+1);
    }

    //sort heap
    for(int i = 0; i < k; i++){
      int tmp = nums[0];
      nums[0] = nums[n-i];
      nums[n-i] = tmp;
      adjustHeap(nums, 0, n-i);
    }

    return nums[n-k+1];
  }

  public int findKthLargest2(int[] a, int k) {
    int n = a.length;
    int p = quickSelect(a, 0, n - 1, n - k + 1);
    return a[p];
  }

  // return the index of the kth smallest number
  int quickSelect(int[] a, int lo, int hi, int k) {
    // use quick sort's idea
    // put nums that are <= pivot to the left
    // put nums that are  > pivot to the right
    int i = lo, j = hi, pivot = a[hi];
    while (i < j) {
      if (a[i++] > pivot) swap(a, --i, --j);
    }
    swap(a, i, hi);

    // count the nums that are <= pivot from lo
    int m = i - lo + 1;

    // pivot is the one!
    if (m == k)     return i;
      // pivot is too big, so it must be on the left
    else if (m > k) return quickSelect(a, lo, i - 1, k);
      // pivot is too small, so it must be on the right
    else            return quickSelect(a, i + 1, hi, k - m);
  }

  void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
