package com.fullofinspiration.github.leetcode;

public class LengthOfLastWord {
  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("a"));
  }
  //我在本地运行时正确的，但是在网站上是错误的，不知道为啥
  public  static int lengthOfLastWord(String s) {
    int count = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i)!= ' ') {
        count++;
      } else {
        break;
      }
    }
    return count;
  }
}
