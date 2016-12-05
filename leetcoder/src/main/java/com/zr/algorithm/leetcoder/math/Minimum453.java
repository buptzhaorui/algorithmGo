package com.zr.algorithm.leetcoder.math;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * User: zhaorui
 * Date: 2016/12/5
 * Time: 13:43
 */
public class Minimum453 {
  /**
   * Incrementing all but one is equivalent to decrementing that one.
   * So let's do that instead. How many single-element decrements to make all equal?
   * No point to decrementing below the current minimum,
   * so how many single-element decrements to make all equal to the current minimum?
   * Just take the difference from
   * what's currently there (the sum) to what we want (n times the minimum).
   */
  public int minMoves(int[] nums) {
    return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().orElse(0);
  }

  public int minMoves2(int[] nums) {
    if (nums.length == 0) return 0;
    int min = nums[0];
    for (int n : nums) min = Math.min(min, n);
    int res = 0;
    for (int n : nums) res += n - min;
    return res;
  }
}
