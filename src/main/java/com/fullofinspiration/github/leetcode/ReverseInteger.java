package com.fullofinspiration.github.leetcode;

public class ReverseInteger {

  public static void main(String[] args) {
    reverse(120);
  }

  //此处有个缺陷，如果是大于long的数值该怎么办，仍然无法解决
  public int reverse1(int x) {
    long result = 0;
    while (x != 0) {
      result = result * 10 + x % 10;
      x /= 10;
    }
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
      return 0;
    }
    return (int) result;
  }

  public static int reverse(int x) {
    int result = 0;
    while (x != 0) {
      if (x > 0 && (Integer.MAX_VALUE - x % 10) / 10 < result) {
        return 0;
      }
      if (x < 0 && (result < (Integer.MIN_VALUE - x % 10) / 10)) {
        return 0;
      }
      result = result * 10 + x % 10;
      x /= 10;
    }
    return result;
  }

}
