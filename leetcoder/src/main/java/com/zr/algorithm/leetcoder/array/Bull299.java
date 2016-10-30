package com.zr.algorithm.leetcoder.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * User: zhaorui
 * Date: 2016/10/29
 * Time: 10:19
 */
public class Bull299 {
  public String getHint(String secret, String guess) {
    int a = 0;
    int b = 0;
    HashMap<Integer, Integer> tmp = new HashMap<>();
    HashSet<Integer> aSet = new HashSet<>();

    int n = secret.length();
    System.out.println("length: " + n);
    for(int i = 0; i < n; i++){
      char originChar = secret.charAt(i);
      if(originChar == guess.charAt(i)){
        a++;
        aSet.add(i);
      }else{
        int originInt = (int)originChar;
        if(tmp.containsKey(originInt)){
          tmp.put(originInt, tmp.get(originInt) + 1);
        }else{
          tmp.put(originInt, 1);
        }
      }
    }
    for(int i = 0; i < n; i++){
      int guessInt = (int)guess.charAt(i);
      if(tmp.containsKey(guessInt) && !aSet.contains(i)){
        b++;
        int value = tmp.get(guessInt);
        if(value == 1){
          tmp.remove(guessInt);
        }else{
          tmp.put(guessInt, value - 1);
        }
      }
    }

    return a + "A" + b + "B";
  }
}
