package com.zr.algorithm.leetcoder.array;

import java.util.*;

/**
 * User: zhaorui
 * Date: 2016/10/19
 * Time: 19:55
 */
public class CombinationSum39 {
  private void combine(List<List<Integer>> rst, List<Integer> tmp, int[] candidates, int start, int target){
    if(target == 0){
      rst.add(new ArrayList<>(tmp));
      return;
    }

    if(target > 0){
      for(int i = start; i < candidates.length && candidates[i] <= target; i++){
        tmp.add(candidates[i]);
        combine(rst, tmp, candidates, i, target-candidates[i]);
        tmp.remove(tmp.size()-1);
      }
    }
  }
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> rst = new ArrayList<>();
    Arrays.sort(candidates);
    if(candidates.length == 0) return rst;
    combine(rst, new ArrayList<>(), candidates, 0, target);
    return rst;
  }
}
