package com.fullofinspiration.github.leetcode;

public class Palindrom {

  public static void main(String[] args) {
    boolean palindrom = isPalindrome(121);
    System.out.println(palindrom);
  }

  //这个方法需要额外的一个字符串
  public static boolean isPalindrome1(int x) {
    String s = String.valueOf(x);
    int start = 0, end = s.length() - 1;
    while (start < end && s.charAt(start) == s.charAt(end)) {
      start++;
      end--;
    }
    if (start >= end) {
      return true;
    }
    return false;
  }

  /**
   * 此方法不需要转成字符串
   */
  public static boolean isPalindrome(int x) {
    if (x < 0 || (x %10 ==0 && x != 0)) {
      return false;
    }
    int result = 0;
    while (x > result) {
      result = result * 10 + x % 10;
      x = x / 10;
    }
    if (x == result || x == result/ 10) {
      return true;
    }
    return false;
  }
}
