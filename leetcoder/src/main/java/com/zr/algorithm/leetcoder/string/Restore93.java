package com.zr.algorithm.leetcoder.string;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhaorui
 * Date: 2017/2/2
 * Time: 23:11
 */
public class Restore93 {
  public List<String> restoreIpAddresses(String s) {
    List<String> solutions = new ArrayList<String>();
    restoreIp(s, solutions, 0, "", 0);
    return solutions;
  }

  private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
    if (count > 4) return;
    if (count == 4 && idx == ip.length()) solutions.add(restored);

    for (int i=1; i<4; i++) {
      if (idx+i > ip.length()) break;
      String s = ip.substring(idx,idx+i);
      if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
      restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
    }
  }
}
