package com.zr.algorithm.leetcoder.hashtable;

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

  public String getHint2(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
      int s = Character.getNumericValue(secret.charAt(i));
      int g = Character.getNumericValue(guess.charAt(i));
      if (s == g) bulls++;
      else {
        if (numbers[s] < 0) cows++;
        if (numbers[g] > 0) cows++;
        numbers[s] ++;
        numbers[g] --;
      }
    }
    return bulls + "A" + cows + "B";
  }
}
