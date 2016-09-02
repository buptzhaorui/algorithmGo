package com.zr.algorithm.leetcoder.array;

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

  public static void main(String[] args) {
    int[] nums = new int[]{3,2,34,2,2};
    Solution solution = new Solution();
//    int count = solution.removeElement3(nums, 2);
//    System.out.println("count: " + count);
//    for(int i = 0; i < count; i++){
//      System.out.println(nums[i]);
//    }
    System.out.print(solution.countPrimes2(4999999));

  }
}
