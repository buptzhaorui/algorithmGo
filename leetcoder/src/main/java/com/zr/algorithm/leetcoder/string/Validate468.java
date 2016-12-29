package com.zr.algorithm.leetcoder.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: zhaorui
 * Date: 2016/12/29
 * Time: 14:54
 */
public class Validate468 {
  public String validIPAddress(String IP) {
    String ip4Reg = "^([1-9]\\d{0,2}|0)(\\.([1-9]\\d{0,2}|0))(\\.([1-9]\\d{0,2}|0))(\\.([1-9]\\d{0,2}|0))$";
    String ip6Reg = "^(0*[0-9a-fA-F]{1,4})(:0*[0-9a-fA-F]{1,4}){7}$";

    Pattern r4 = Pattern.compile(ip4Reg);
    Pattern r6 = Pattern.compile(ip6Reg);

    Matcher m4 = r4.matcher(IP);
    Matcher m6 = r6.matcher(IP);

    if(m4.find()){
      if(m4.groupCount() == 4){
        for(int i = 1; i <= 4; i++){
          int v = Integer.valueOf(m4.group(i));
          if(!(v >= 0 && v <= 255)) return "Neither";
        }
      }else{
        return "Neither";
      }
      return "IPv4";
    }else if(m6.find()){
      return "IPv6";
    }else{
      return "Neither";
    }
  }
}
