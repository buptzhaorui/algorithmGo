package com.zr.algorithm.leetcoder.array;

import java.util.*;

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

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    boolean b = false;
    int n = nums.length;

    for(int i = 0; i < k; i++){
      for(int j = i; j < n; j += k){
        for(int m = j; m <= j + k && m < n; m++)
          if(nums[j] == nums[m]){
            b = true;
            break;
          }
      }
    }

    return b;
  }

  public boolean containsNearbyDuplicate2(int[] nums, int k) {
    HashSet<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
      if (i > k) set.remove(nums[i - k - 1]);
      if (!set.add(nums[i])) return true;
    }

    return false;
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      Integer value = map.get(target - nums[i]);
      if(value == null){
        map.put(nums[i], i);
      }else{
        return new int[]{value, i};
      }
    }
    return new int[]{};
  }

  public List<List<Integer>> generate(int numRows) {
    Double[] nums = new Double[numRows];
    List<List<Integer>> rst = new ArrayList<>();
    for(int i = 0; i < numRows; i ++){
      if(i == 0) nums[i] = 1d;
      else nums[i] = nums[i-1]*i;
      List<Integer> rows = new ArrayList<>();
      for(int j = 0; j <= i; j++){
        Double value = nums[i]/(nums[j]*nums[i-j]);
        rows.add(value.intValue());
        rows.add(0, 1);
      }
      rst.add(rows);
    }
    return rst;
  }

  public List<List<Integer>> generate2(int numRows) {
    List<List<Integer>> rst = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    for(int i = 0; i < numRows; i ++){
      row.add(0, 1);
      for(int j = 1; j < row.size() - 1; j++){
        row.set(j, row.get(j) + row.get(j+1));
      }
      rst.add(row);
    }
    return rst;
  }

  public List<List<Integer>> generate3(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    if (numRows <=0){
      return triangle;
    }
    for (int i=0; i<numRows; i++){
      List<Integer> row =  new ArrayList<Integer>();
      for (int j=0; j<i+1; j++){
        if (j==0 || j==i){
          row.add(1);
        } else {
          row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
        }
      }
      triangle.add(row);
    }
    return triangle;
  }

  public List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<>();
    for(int i = 0; i <= rowIndex; i++){
      row.add(0, 1);
      for(int j = 1; j < i; j++){
        row.set(j, row.get(j)+row.get(j+1));
      }
    }
    return row;
  }


  public void moveZeroes(int[] nums) {
    int n = nums.length;
    int j = 1;
    for(int i = 0; i < n; i++){
      if(nums[i] == 0){
        while(j < n && nums[j] == 0){
          j++;
        }
        if( j == n){
          break;
        }else{
          int tmp = nums[j];
          nums[j] = nums[i];
          nums[i] = tmp;
        }
      }else{
        j++;
      }
    }
  }

  public void moveZeroes2(int[] nums) {
    if  (nums==null) return;
    int zeroCount = 0;
    for (int i = 0;i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroCount++;
      } else {
        nums[i - zeroCount] = nums[i];
      }
    }
    while (zeroCount > 0) {
      nums[nums.length - zeroCount--] = 0;
    }
  }

  public void moveZeroes3(int[] nums){
    int index = 0;
    for(int num: nums){
      if(num != 0){
        nums[index++] = num;
      }
    }
    while(index < nums.length){
      nums[index++] = 0;
    }
  }

  public int maxProfit(int[] prices) { //当前的值减去之前最小的
    int profit = 0;
    int min = Integer.MAX_VALUE;
    for(int price: prices){
      min = Integer.min(price, min);
      profit = Integer.max(price - min, profit);
    }
    return profit;
  }

  public int maxProfit2(int[] prices) {
    int ans=0;
    if(prices.length==0)
    {
      return ans;
    }
    int bought=prices[0];
    for(int i=1;i<prices.length;i++)
    {
      if(prices[i]>bought)
      {
        if(ans<(prices[i]-bought))
        {
          ans=prices[i]-bought;
        }
      }
      else
      {
        bought=prices[i];
      }
    }
    return ans;
  }

  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for(int num: nums){
      if(set.contains(num)) return true;
      else set.add(num);
    }
    return false;

  }

  public boolean containsDuplicate2(int[] nums) {

    Arrays.sort(nums);
    for(int ind = 1; ind < nums.length; ind++) {
      if(nums[ind] == nums[ind - 1]) {
        return true;
      }
    }
    return false;
  }

  public int maxProfit3(int[] prices) {
    int profit = 0;
    for(int i = 0; i < prices.length; i++){
      int diff = prices[i+1] - prices[i];
      if(diff > 0){
        profit += diff;
      }
    }
    return profit;
  }

  private int pathSum(int[][] grid, int m, int n) {
    int sum = 0;
    if(m == 0 || n == 0){
      return sum;
    }else if(m == 1){
      for(int i = 0; i < n; i++){
        sum += grid[0][i];
      }
    }else if(n == 1){
      for(int i = 0; i < n; i++){
        sum += grid[i][0];
      }
    }else{
      sum = Integer.min(pathSum(grid, m, n-1) + grid[m-1][n-1], pathSum(grid, m-1, n) + grid[m-1][n-1]);
    }
    return sum;
  }

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    if(m == 0) return 0;
    else return pathSum(grid, m, grid[0].length);
  }

  public int minPathSum2(int[][] grid) {
    int m = grid.length;// row
    int n = grid[0].length; // column
    for(int j = 1; j < n; j++) grid[0][j] = grid[0][j] + grid[0][j-1];
    for(int i = 1; i < m; i++) grid[i][0] = grid[i][0] + grid[i-1][0];
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
      }
    }
    return grid[m - 1][n - 1];
  }

  public int search(int[] nums, int target) {
    int n = nums.length;
    int left = 0;
    int right = n-1;

    while(left < right){
      int mid = (left + right) >> 1;

      if(nums[mid] == target) return mid;

      if(nums[left] <= target && target < nums[mid]){
        right = mid - 1;
      }else if(nums[mid] < target && target <= nums[right]){
        left = mid + 1;
      }else{
        if(nums[left] > nums[mid]){
          right = mid - 1;
        }else if(nums[mid] > nums[right]){
          left = mid + 1;
        }else{
          return -1;
        }
      }

    }

    if(nums[left] == target) return left;
    else return -1;
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

