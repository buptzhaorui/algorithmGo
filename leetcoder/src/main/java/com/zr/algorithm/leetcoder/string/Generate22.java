package com.zr.algorithm.leetcoder.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2017/2/3
 * Time: 15:03
 */
public class Generate22 {
  private void recursive(List<String> rst, String cur, int left, int right) {
    if(left == 0 && right == 0) rst.add(cur);

    if(left > 0)
      recursive(rst, cur + "(", left - 1, right);

    if(right > left)
      recursive(rst, cur + ")", left, right - 1);
  }
  public List<String> generateParenthesis(int n) {
    ArrayList<String> rst = new ArrayList<>();
    if(n < 0) return rst;

    recursive(rst, "", n, n);
    return rst;
  }
}
