package com.fullofinspiration.github.leetcode;

public class MyPow {

  /**
   * 按照参考答案写的，但是答案有错误，没有考虑到Integer.MIN_VALUE的情况，
   * 应该取反后再减一才行
   * @param x
   * @param n
   * @return
   */
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      x = 1 / x;
      n = -n;
      if (-n == Integer.MIN_VALUE) {
        return x*myPow(x, n-1);
      }
    }
    if (n % 2 == 0) {
      return myPow(x * x, n / 2);
    } else {
      return x * myPow(x * x, n / 2);
    }
  }
}
