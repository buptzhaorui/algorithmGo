package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/16
 * Time: 9:49
 */
public class Integer343 {
  public int integerBreak(int n) {
    int[] products = new int[n+1];
    products[1] = 1;
    for(int i = 2; i <= n; i++){
      for(int j = 1; j < i; j++){
        products[i] = Math.max(Math.max(products[i], products[j] * (i-j)), j*(i-j));
      }
    }

    return products[n];
  }

  /**
   *
   * The first thing we should consider is : What is the max product if we break a number N into two factors?

   I use a function to express this product: f=x(N-x)

   When x=N/2, we get the maximum of this function.

   However, factors should be integers. Thus the maximum is (N/2)*(N/2) when N is even or (N-1)/2 *(N+1)/2 when N is odd.

   When the maximum of f is larger than N, we should do the break.

   (N/2)*(N/2)>=N, then N>=4

   (N-1)/2 *(N+1)/2>=N, then N>=5

   These two expressions mean that factors should be less than 4, otherwise we can do the break and get a better product. The factors in last result should be 1, 2 or 3. Obviously, 1 should be abandoned. Thus, the factors of the perfect product should be 2 or 3.

   The reason why we should use 3 as many as possible is

   For 6, 3 * 3>2 * 2 * 2. Thus, the optimal product should contain no more than three 2.

   Below is my accepted, O(N) solution.
   *
   * */
  public int integerBreak2(int n){
    if(n==2) return 1;
    if(n==3) return 2;
    int product = 1;
    while(n>4){
      product*=3;
      n-=3;
    }
    product*=n;

    return product;
  }
}
