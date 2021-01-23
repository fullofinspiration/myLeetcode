package com.fullofinspiration.github.leetcode;

public class Atoi {

  public static void main(String[] args) {

  }

  /**
   * 过程有点繁琐
   * 1 仔细把握好每一个需求点
   * 2 代码要过关
   * 3 Integer.MIN_VALUE由于是16进制，它的相反数仍然是负数，不知道是为什么。
   * @param str
   * @return
   */
  public static int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int index = 0;
    while (index < str.length() && str.charAt(index) == ' ') {
      index++;
    }
    if (index >= str.length()) {
      return 0;
    }
    int result =0,flag = 1;
    if (str.charAt(index) == '+' ) {
      index++;
    } else if (str.charAt(index) == '-') {
      flag = -1;
      index++;
    }
    while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
      int num = str.charAt(index) - '0';
      if (flag==1 && (Integer.MAX_VALUE -  num)/10 < result) {
        return Integer.MAX_VALUE;
      }
      if (flag==-1 && -result < (Integer.MIN_VALUE + num )/10) {
        return Integer.MIN_VALUE;
      }
      result = result * 10 + num ;
      index++;
    }
    return result * flag;
  }
}
