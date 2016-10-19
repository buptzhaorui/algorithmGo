package com.zr.algorithm.leetcoder.array;

import java.util.Arrays;

/**
 * User: zhaorui
 * Date: 2016/10/19
 * Time: 16:04
 */
public class ThirdMax414 {
  public int thirdMax(int[] nums) {
    int top1 = Integer.MIN_VALUE, top2 = Integer.MIN_VALUE, top3 = Integer.MIN_VALUE;
    System.out.println(Integer.MIN_VALUE);
    int count = 0;
    for(int num: nums){
      if(num > top1){
        count ++;
        top3 = top2;
        top2 = top1;
        top1 = num;
      }else if(num == top1 && count == 0){
        count ++;
      }else if(num < top1 && num > top2){
        count ++;
        top3 = top2;
        top2 = num;
      }else if(num < top1 && num == top2 && count == 1){
        count ++;
      }else if(num < top2 && num >= top3){
        count ++;
        top3 = num;
      }
    }

    if(count >= 3){
      return top3;
    }else{
      return top1;
    }
  }
}
