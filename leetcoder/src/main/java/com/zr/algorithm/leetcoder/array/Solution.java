package com.zr.algorithm.leetcoder.array;

import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2016/9/1
 * Time: 14:56
 */
public class Solution {

  public int removeElement(int[] nums, int val) {
    int i = 0;
    int j = 0;
    for( ; i < nums.length; i++){
      if(nums[i] == val){
        if(j < i) j = i;

        while(j < nums.length && nums[j] == val){ //find element not equal to val
          j++;
        }

        if(j == nums.length) return i;
        else{
          int temp;
          temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
          j++;
        }
      }
    }
    return i;
  }


  public int removeElement2(int[] nums, int val) {
    int j = 0;

    for(int i = 0; i < nums.length; i++) {
      if(nums[i] != val){
        nums[j] = nums[i];
        j++;
      }
    }

    return j;
  }

  public int removeElement3(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while(i < n){
      if(nums[i] == val){
        nums[i] = nums[n-1];
        n--;
      }else{
        i++;
      }
    }

    return i;
  }

  public int countPrimes(int n) {
    if(n >= 2){
      int size = 1;
      int[] primes = new int[n];
      primes[size-1] = 2;

      int i = 3;
      while(i <= n){
        int j = 0;
        for( ; j < size; j++){
          if(i % (primes[j]) == 0) break;
        }
        if(j == size){
          primes[size] = i;
          size++;
        }
        i += 2;
      }
      return size;
    }else{
      return 0;
    }
  }

  /**
   * Sieve of Eratosthenes 埃拉托斯特尼筛法
   * 1.从第一个数2开始，2是素数，那么2的倍数都标记为合数；接着是3，3是素数，那么3的倍数都标记为合数，依次类推。
   * 2.由于4已经被标记为合数了，那么它的倍数也一定标记过，所以跳过合数倍数的标记过程。
   * 3.需要标记的数实际上是素数的倍数，但是这里有一个优化。对于素数p,只要从p^2开始标记即可，因为p*(p-1)一定在
   * 处理p-1的倍数标记过程中标记过，或者是在p-1的因子的倍数标记过程被标记过。
   * 4.最后一个小技巧就是循环到i^2 < n即可，因为标记的时候是从i^2开始标记的
   *
   */
  public int countPrimes2(int n) {
    boolean[] isPrime = new boolean[n];
    for(int i = 2; i < n; i++) isPrime[i] = true;
    for(int i = 2; i * i < n; i++){
      if(!isPrime[i]) continue;
      for(int j = i * i; j < n; j += i) isPrime[j] = false;
    }
    int count = 0;
    for(int i = 2; i < n; i++){
      if(isPrime[i]) count++;
    }
    return count;
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i1 = m-1;
    int i2 = n-1;
    int i = m+n-1;

    while(i1 >= 0 && i2 >= 0){
      if(nums1[i1] > nums2[i2]){
        nums1[i] = nums1[i1];
        i1--;
        i--;
      }else{
        nums1[i] = nums2[i2];
        i2--;
        i--;
      }
    }
    if(i1 < 0){
      for( ; i2 >= 0; i2--){
        nums1[i] = nums2[i2];
        i--;
      }
    }else{
      for( ; i1 >= 0; i1--){
        nums1[i] = nums1[i1];
        i--;
      }
    }
  }


  public int[] plusOne(int[] digits) {
    int size = digits.length;
    int carry = 1;

    for(int i = size - 1; i >= 0; i--){
      if(carry == 1){
        int tmp = (digits[i] + 1) % 10;
        carry = (digits[i] + 1) / 10;
        digits[i] = tmp;
      }else{
        break;
      }
    }

    if(carry == 1){
      int[] rst = new int[size+1];
      rst[0] = 1;
      for(int i = 1; i <= size; i++){
        rst[i] = digits[i-1];
      }
      return rst;
    }else{
      return digits;
    }

  }

  /**
   *  注意题中说众数出现的次数大于n/2的下取整，成对删除不同的两个数，留到最后的就是众数
   */
  public int majorityElement(int[] nums) {
    int candidate = 0;
    int count = 0;
    for(int i = 0; i < nums.length; i++){
      if(count == 0){
        candidate = nums[i];
        count ++;
      }else{
        if(candidate == nums[i]){
          count++;
        }else{
          count--;
        }
      }
    }
    return candidate;
  }

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    if(k != 0){
      int[] tmp = new int[k];
      for(int i = 0; i < k; i++){
        tmp[i] = nums[n-k+i];
      }
      for(int i = n - k -1; i >= 0; i--){
        nums[i+k] = nums[i];
      }
      for(int i = 0; i < k; i++){
        nums[i] = tmp[i];
      }
    }
  }

  public void rotate2(int[] nums, int k) {
    int n = nums.length;
    k = k%n;
    int[] temp = Arrays.copyOfRange(nums, 0, n-k);
    System.arraycopy(nums, n-k, nums, 0, k);
    System.arraycopy(temp, 0, nums, k, n-k);
  }

  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    int count = 0;
    for(int i = 0; i < n; i++){
      while(i < n && nums[i] == nums[count]){
        i++;
      }
      if(i == n){
        break;
      }else{
        nums[++count] = nums[i];
      }
    }
    return n == 0 ? 0 : (count + 1);
  }

  public int removeDuplicates2(int[] nums) {
    int i = nums.length > 0 ? 1 : 0;
    for(int n: nums){
      if(nums[i-1]< n){
        nums[i++] = n;
      }
    }
    return i;
  }


  public static void main(String[] args) {
    int[] nums = new int[]{3,2,34,2,2};
    Solution solution = new Solution();
//    int count = solution.removeElement3(nums, 2);
//    System.out.println("count: " + count);
//    for(int i = 0; i < count; i++){
//      System.out.println(nums[i]);
//    }
//    System.out.print(solution.countPrimes2(4999999));
    int[] nums1 = new int[]{1,2,3};

  }
}

