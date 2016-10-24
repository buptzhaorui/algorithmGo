package com.zr.algorithm.leetcoder.array;

/**
 * User: zhaorui
 * Date: 2016/10/24
 * Time: 14:45
 */

/**
 * 用一个例子来说明，比如排列是(2,3,6,5,4,1)，求下一个排列的基本步骤是这样：
 * 1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
 * 2) 接下来分两种情况：
 *    (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，
 *    其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
 *    (2) 否则，如果p存在，从p开始往后找，找到下一个数就比p对应的数小的数字，然后两个调换位置，
 *    比如例子中的4。调换位置后得到(2,4,6,5,3,1)。
 *    最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 这个即是要求的下一个排列。
 */
public class NextPermutation31 {
  private void reverse(int[] nums, int start, int end) {
    while(start < end){
      int tmp = nums[end];
      nums[end] = nums[start];
      nums[start] = tmp;
      start ++;
      end --;
    }
  }

  public void nextPermutation(int[] nums) {
    int n = nums.length;
    if( n <= 1) return;
    int p = n - 2;
    while(p >= 0 && nums[p] >= nums[p+1]) p--;

    if(p < 0){
      reverse(nums, 0, n-1);
    }else{
      for(int i = n-1; i > p; i--){
        if(nums[i] > nums[p]){
          int tmp = nums[p];
          nums[p] = nums[i];
          nums[i] = tmp;
          break;
        }
      }
      reverse(nums, p+1, n-1);
    }
  }
}
