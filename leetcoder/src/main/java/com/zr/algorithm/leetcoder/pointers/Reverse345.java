package com.zr.algorithm.leetcoder.pointers;

/**
 * User: zhaorui
 * Date: 2016/12/20
 * Time: 14:25
 */
public class Reverse345 {
  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
      c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
  }
  public String reverseVowels(String s) {
    StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
    int left = 0, right = s.length() - 1;
    while(left < right){
      if(!isVowel(s.charAt(left))){
        sb1.append(s.charAt(left));
        left++;
      }else if(!isVowel(s.charAt(right))){
        sb2.insert(0, s.charAt(right));
        right--;
      }else{
        sb2.insert(0, s.charAt(left));
        sb1.append(s.charAt(right));
        left++;
        right--;
      }
    }

    if(left == right) return sb1.toString() + s.charAt(left) + sb2.toString();
    else return sb1.toString() + sb2.toString();
  }

  public String reverseVowels2(String s) {
    if(s == null || s.length()==0) return s;
    String vowels = "aeiouAEIOU";
    char[] chars = s.toCharArray();
    int start = 0;
    int end = s.length()-1;
    while(start<end){

      while(start<end && !vowels.contains(chars[start]+"")){
        start++;
      }

      while(start<end && !vowels.contains(chars[end]+"")){
        end--;
      }

      char temp = chars[start];
      chars[start] = chars[end];
      chars[end] = temp;

      start++;
      end--;
    }
    return new String(chars);
  }
}
