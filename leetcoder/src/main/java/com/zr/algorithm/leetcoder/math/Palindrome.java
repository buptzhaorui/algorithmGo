package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/4
 * Time: 16:05
 */
public class Palindrome {
  public boolean isPalindrome(int x) {
    if(x < 0) return false;

    int n = 1;
    int tmp = x;
    while(tmp / 10 != 0){
      tmp /= 10;
      n++;
    }
    while(n > 1){
      int base = (int)Math.pow(10, n-1);
      if(x % 10 == x / base){
        n -= 2;
        x = x % base / 10;
      }else{
        return false;
      }
    }
    return true;
  }

  public boolean isPalindrome2(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
      rev = rev*10 + x%10;
      x = x/10;
    }
    return (x==rev || x==rev/10);
  }
}
