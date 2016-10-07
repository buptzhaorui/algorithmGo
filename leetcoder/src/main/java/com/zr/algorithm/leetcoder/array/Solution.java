package com.zr.algorithm.leetcoder.array;

import sun.reflect.generics.tree.Tree;

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


  public int uniquePaths(int m, int n) {
    int[][] arr = new int[m][n];
    for(int i = 0; i < m; i++) arr[i][0] = 1;
    for(int j = 0; j < n; j++) arr[0][j] = 1;
    for(int i = 1; i < m; i++){
      for(int j = 1; j < n; j++){
        arr[i][j] = arr[i][j-1] + arr[i-1][j];
      }
    }

    return arr[m-1][n-1];
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if(obstacleGrid[0][0] == 1)
      obstacleGrid[0][0] = 0;
    else
      obstacleGrid[0][0] = 1;
    for(int i = 1; i < m; i++){
      if (obstacleGrid[i][0] == 1)
        obstacleGrid[i][0] = 0;
      else
        obstacleGrid[i][0] = obstacleGrid[i-1][0];
    }
    for(int j = 1; j < n; j++){
      if (obstacleGrid[0][j] == 1)
        obstacleGrid[0][j] = 0;
      else
        obstacleGrid[0][j] = obstacleGrid[0][j-1];
    }
    for(int i = 1; i < m; i++){
      for(int j = 1; j < n; j++){
        if(obstacleGrid[i][j] == 1)
          obstacleGrid[i][j] = 0;
        else
          obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
      }
    }

    return obstacleGrid[m-1][n-1];
  }

  public int findPeakElement(int[] nums) {
    int index = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] >= nums[index]) index++;
      else break;
    }
    return index;
  }

  public int findPeakElement2(int[] nums) {
    int low = 0;
    int high = nums.length-1;

    while(low < high)
    {
      int mid1 = (low+high)/2;
      int mid2 = mid1+1;
      if(nums[mid1] < nums[mid2])
        low = mid2;
      else
        high = mid1;
    }
    return low;
  }

  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while(left < right){
      int mid = (left + right) >> 1;
      if(nums[left] <= nums[mid]){ //left is sorted
        if(nums[mid] <= nums[right]){ //right is sorted
          return nums[left];
        }else{
          left = mid + 1;
        }
      }else{
        right = mid;
      }
    }

    return nums[left];
  }

  public int maxProduct(int[] nums) {
    int product = nums[0];
    int maxPositive = nums[0];
    int minNegative = nums[0];
    for(int i = 1; i < nums.length; i++){
      int tmp = maxPositive;
      maxPositive = Math.max(maxPositive * nums[i], Math.max(minNegative * nums[i], nums[i]));
      minNegative = Math.min(tmp * nums[i], Math.min(minNegative * nums[i], nums[i]));
      product = Math.max(product, maxPositive);
    }
    return product;
  }

  public void gameOfLife(int[][] board) {
    // 0 dead -> dead
    // 1 alive -> alive
    // 2 alive -> dead
    // 3 dead -> alive
    int rows = board.length;
    if(rows == 0) return;

    int cols = board[0].length;
    int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    for(int row = 0; row < rows; row ++){
      for(int col = 0; col < cols; col ++){
        int aliveAround = 0;
        for(int i = 0; i < 8; i++){
          int x = row + dx[i];
          int y = col + dy[i];
          if(x >= 0 && x < rows && y >= 0 && y < cols && (board[x][y] == 1 || board[x][y] == 2)){
            aliveAround ++;
          }
        }
        if(board[row][col] == 1 && (aliveAround < 2 || aliveAround > 3)) board[row][col] = 2;
        if(board[row][col] == 0 && aliveAround == 3) board[row][col] = 3;
      }
    }

    for(int row = 0; row < rows; row ++)
      for(int col = 0; col < cols; col ++)
        board[row][col] %= 2;
  }

  //递归回溯
  public void recursiveBack(int[] s, int n, int k, int l) {
    for(s[l] = s[l-1] + 1; s[l] < n; s[l] ++){
      if(l == k){
        for(int i = 1; i <= k; i++)
          System.out.print(s[i] + " ");
        System.out.println();
      }else{
        recursiveBack(s, n, k, l+1);
      }
    }
  }

  public void forBack(int[] s, int n, int k, int l) {
    s[l] = 0;
    while(l != 0){
      while(s[l] < n){
        if(l == k){
          System.out.println();
          s[l] += 1;
        }else{
          l += 1;
          s[l] += 1;
        }
      }
      l --;
      s[l] += 1;
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> rst = new ArrayList<>();
    int n = nums.length;
    int max = 1 << n;
    for(int i = 0; i < max; i++){
      List<Integer> tmp = new ArrayList<>();
      int j = i;
      int index = 0;
      while(j > 0){
        if((j&1) == 1){
          tmp.add(nums[index]);
        }
        index ++;
        j >>= 1;
      }
      rst.add(tmp);
    }
    return rst;
  }

  public List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> rst = new ArrayList<>();
    int n = nums.length;
    int[] choice = new int[n];
    List<Integer> tmp = new ArrayList<>();
    int index = 0;
    choice[index] = 0;
    while(index >= 0){
      //处理当前层
      while(choice[index] < 2){
        if(index == n-1){
          List<Integer> set = new ArrayList<>();
          set.addAll(tmp);
          if(choice[index] == 1){
            set.add(nums[index]);
          }
          rst.add(set);
          choice[index] ++;
        }else{
          if(choice[index] == 1){
            tmp.add(nums[index]);
          }
          index ++;
          choice[index] = 0;
        }
      }
      index --;
      if(index >= 0){
        choice[index] ++;
        int count = 0;
        for(int i = 0; i < index; i++){
          if(choice[i] == 1) count++;
        }
        tmp = tmp.subList(0, count);
      }

    }

    return rst;
  }

  private void subsetRecursive(List<List<Integer>> rst, int[] nums, int l, List<Integer> tmp){
    if(l == nums.length){
      rst.add(tmp);
    }else{
      subsetRecursive(rst, nums, l+1, new ArrayList<>(tmp));
      tmp.add(nums[l]);
      subsetRecursive(rst, nums, l+1, new ArrayList<>(tmp));
    }
  }

  public List<List<Integer>> subsets3(int[] nums){
    List<List<Integer>> rst = new ArrayList<>();
    subsetRecursive(rst, nums, 0, new ArrayList<>());
    return rst;
  }

  private void subsetWithDupRecursive(List<List<Integer>> rst, int[] nums, int l, List<Integer> tmp){
    rst.add(new ArrayList<>(tmp));

    for(int i = l; i < nums.length; i++){
      if( i > l && nums[i] == nums[i-1]) continue;
      tmp.add(nums[i]);
      subsetWithDupRecursive(rst, nums, i+1, tmp);
      tmp.remove(tmp.size()-1);
    }
  }


  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> rst = new ArrayList<>();
    Arrays.sort(nums);
    subsetWithDupRecursive(rst, nums, 0, new ArrayList<>());
    return rst;
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int minimum = 0;
    int rows = triangle.size();
    if(rows > 0){
      int[] total = new int[rows];
      total[0] = triangle.get(0).get(0);
      minimum = total[0];
      for(int row = 1; row < rows; row++){
        List<Integer> rowList = triangle.get(row);
        int buf = total[0] + rowList.get(0);
        minimum = buf;
        int n = rowList.size();
        for(int i = 1; i < n; i ++){
          int cur = rowList.get(i);
          if(i == n-1){
            int tmp = total[i-1] + cur;
            minimum = Math.min(minimum, tmp);
            total[i-1] = buf;
            total[i] = tmp;
          }else{
            int tmp = Math.min(total[i-1] + cur, total[i] + cur);
            minimum = Math.min(minimum, tmp);
            total[i-1] = buf;
            buf = tmp;
          }
        }
      }
    }

    return minimum;
  }

  public int missingNumber(int[] nums) {
    int n = nums.length;
    int total = 0;
    for(int num: nums){
      total += num;
    }
    return (n*(n+1) >> 1) - total;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  private TreeNode buildTree(int[] inorder, int i1,
                             int[] postorder, int i2, int num) {
    if(num == 0){
      return null;
    }else{
      int val = postorder[i2+num-1];
      TreeNode node = new TreeNode(val);
      int i11 = i1;
      while(inorder[i11++] != val);
      node.left = buildTree(inorder, i1, postorder, i2, i11-i1-1);
      node.right = buildTree(inorder, i11, postorder, i2+i11-i1-1, num+i1-i11);

      return node;
    }
  }

  private TreeNode buildTree2(int[] preorder, int i1,
                             int[] inorder, int i2, int num) {
    if(num == 0){
      return null;
    }else{
      int val = preorder[i1];
      TreeNode node = new TreeNode(val);
      int i22 = i2;
      while(inorder[i22++] != val);
      node.left = buildTree2(preorder, i1+1, inorder, i2, i22-i2-1);
      node.right = buildTree2(preorder, i1+i22-i2, inorder, i22, num+i2-i22);

      return node;
    }
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, 0, postorder, 0, inorder.length);
  }

  public int maxRotateFunction(int[] A) {
    int n = A.length;
    if(n == 0) return 0;
    int sum = 0;
    int F = 0;

    for(int i = 0; i < n; i++){
      sum += A[i];
      F += i*A[i];
    }

    int max = F;

    for(int i = 1; i < n; i++){
      F = F + sum - n*A[n-i];
      max = Math.max(max, F);
    }

    return max;
  }

  public int removeDuplicates22(int[] nums) {
    int index = 0;
    int counter = 1;
    int n = nums.length;
    if( n == 0) return 0;
    for(int i = 1; i < n; i++){
      if(nums[i] == nums[index]){
        if(++counter <= 2){
          nums[++index] = nums[i];
        }else{
          while(++i < n && nums[i] == nums[index]);
          if(i == n) return index+1;
          nums[++index] = nums[i];
          counter = 1;
        }
      }else{
        nums[++index] = nums[i];
        counter = 1;
      }
    }
    return index+1;
  }

  public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(exist(board, w, j, i, 0)) return true;
      }
    }
    return false;
  }

  private boolean exist(char[][] board, char[] word, int x, int y, int l){
    if(l == word.length) return true;
    if( x < 0 || y < 0 || y == board.length || x == board[y].length) return false;
    if(board[y][x] != word[l]) return false;
    board[y][x] ^= 256;
    boolean exist = exist(board, word, x-1, y, l+1) ||
      exist(board, word, x+1, y, l+1) ||
      exist(board, word, x, y-1, l+1) ||
      exist(board, word, x, y+1, l+1);
    board[y][x] ^= 256;
    return exist;
  }

  public void sortColors(int[] nums) {
    int left = 0;
    int right = nums.length;

    for(int i = left; i < right; ){
      if(nums[i] == 0){
        nums[i] = nums[left];
        nums[left] = 0;
        left++;
        i++;
      }else if(nums[i] == 2){
        nums[i] = nums[right];
        nums[right] = 2;
        right--;
        i++;
      }else{
        i++;
      }
    }

  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if(m == 0) return false;
    int n = matrix[0].length;
    int left = 0;
    int right = m*n - 1;
    while(left <= right){
      int mid = (left + right) >> 1;
      if(matrix[mid/n][mid%n] == target) return true;
      else if(matrix[mid/n][mid%n] > target) right = mid - 1;
      else left = mid + 1;
    }
    return false;
  }

  public boolean searchMatrix2(int[][] matrix, int target) {
    int m = matrix.length;
    if(m == 0) return false;
    if(matrix[0][0] > target) return false;
    int left = 0;
    int right = m - 1;
    while(left < right){
      int mid = (left + right) >> 1;
      if(matrix[mid][0] == target) return true;
      else if(matrix[mid][0] > target) right = mid - 1;
      else{
        if(left + 1 == right){
          if(matrix[right][0] > target) break;
          else if(matrix[right][0] == target) return true;
          else left = mid + 1;
        }
        else left = mid;
      }
    }

    int n = matrix[left].length;
    if(matrix[left][n-1] < target) return false;
    int l2 = 0;
    int r2 = n - 1;
    while(l2 <= r2){
      int mid = (l2 + r2) >> 1;
      if(matrix[left][mid] == target) return true;
      else if(matrix[left][mid] > target) r2 = mid - 1;
      else l2 = mid + 1;
    }

    return false;
  }

  public void setZeroes(int[][] matrix) {
    int col0 = 1, rows = matrix.length, cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) col0 = 0;
      for (int j = 1; j < cols; j++)
        if (matrix[i][j] == 0)
          matrix[i][0] = matrix[0][j] = 0;
    }

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 1; j--)
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;
      if (col0 == 0) matrix[i][0] = 0;
    }
  }


  public int[][] generateMatrix(int n) {
    int[][] rst = new int[n][n];
    int left = 0;
    int right = n - 1;
    int top = 0;
    int bottom = n - 1;
    int num = 1;

    while(left <= right && top <= bottom){
      for(int i = left; i <= right; i++){
        rst[top][i] = num++;
      }
      top++;
      for(int i = top; i <= bottom; i++){
        rst[i][right] = num++;
      }
      right--;
      for(int i = right; i >= left; i--){
        rst[bottom][i] = num++;
      }
      bottom--;
      for(int i = bottom; i >= top; i--){
        rst[i][left] = num++;
      }
      left++;
    }

    return rst;
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> rst = new ArrayList<>();

    int m = matrix.length;
    if(m == 0) return rst;

    int left = 0;
    int right = matrix[0].length - 1;
    int top = 0;
    int bottom = m - 1;

    while(left <= right && top <= bottom){
      for(int i = left; i <= right; i++){
        rst.add(matrix[top][i]);
      }
      top++;
      for(int i = top; i <= bottom; i++){
        rst.add(matrix[i][right]);
      }
      right--;
      for(int i = right; i >= left; i--){
        if(top <= bottom)
          rst.add(matrix[bottom][i]);
      }
      bottom--;
      for(int i = bottom; i >= top; i--){
        if(left <= right)
          rst.add(matrix[i][left]);
      }
      left++;
    }

    return rst;
  }

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] rst = new int[n];
    if(n == 0) return rst;

    rst[0] = 1;
    for(int i = 1; i < n; i++){
      rst[i] = rst[i-1] * nums[i-1];
    }

    int right = 1;
    for(int i = n-1; i >= 0; i--){
      rst[i] *= right;
      right *= nums[i];
    }

    return rst;
  }

  public List<Integer> majorityElement2(int[] nums) {
    List<Integer> rst = new ArrayList<>();
    int n = nums.length;
    if(n == 0) return rst;
    int candidate1 = 0;
    int candidate2 = 0;
    int count1 = 0;
    int count2 = 0;

    for(int num: nums){
      if(num == candidate1){
        count1++;
      }else if(num == candidate2){
        count2++;
      }else if(count1 == 0){
        count1++;
        candidate1=num;
      }else if(count2 == 0){
        count2++;
        candidate2=num;
      }else{
        count1--;
        count2--;
      }
    }

    int n1 = 0;
    int n2 = 0;

    for(int num: nums){
      if(num == candidate1) n1++;
      if(num == candidate2) n2++;
    }

    if(n1 > n/3) rst.add(candidate1);
    if(candidate1 != candidate2 && n2 > n/3) rst.add(candidate2);
    return rst;
  }

  public boolean canJump(int[] nums) {
    int index = 0, end = 0;
    while(index <= end){
      if(end >= nums.length-1) return true;
      if(nums[index] == 0 && index == end) return false;
      end = Math.max(end, index + nums[index]);
      index++;
    }
    return false;
  }

  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;

    for(int num: nums){
      sum = Math.max(sum+num, num);
      max = Math.max(sum, max);
    }

    return max;
  }

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int tmp;
    for(int i = 0; i < Math.ceil((double)n/2); i++){
      for(int j = i; j < n - 1 - i; j ++){
        tmp = matrix[i][j];
        matrix[i][j] = matrix[n-1-j][i];
        matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        matrix[j][n-1-i] = tmp;
      }
    }
  }

  public static void main( String[] args) {
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

