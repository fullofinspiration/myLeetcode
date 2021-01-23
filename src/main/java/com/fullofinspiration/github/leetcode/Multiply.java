package com.fullofinspiration.github.leetcode;

public class Multiply {

  public static void main(String[] args) {
    multiply("123", "456");
  }

  /**
   * 下面几点非常巧妙，我是想象不到的：
   * 1 循环中把进位问题解决了，不用多次循环
   * 2 判断首位是0时在循环中就判断了，非常巧妙
   * @param num1
   * @param num2
   * @return
   */
  public static String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] nums = new int[m + n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        nums[i + j + 1] += mul;
        nums[i + j] += (nums[i + j + 1] / 10);
        nums[i + j + 1] %= 10;
      }
    }
    StringBuilder s = new StringBuilder();
    for (int i : nums) {
      if (s.length() == 0 && i == 0) {
        continue;
      }
      s.append(i);
    }
    return s.length() == 0 ? "0" : s.toString();
  }


  /**
   * 首先这不是我的想法，这是答案中的想法
   * 我写的太复杂了，有几个缺点：首位是0的判断单独又写了一个
   * 判断条件显得很臃肿，第二个是进位又单独写了一个循环，而标准答案是从低位到高位，
   * 然后进位是在一个循环中完成的。
   * @param num1
   * @param num2
   * @return
   */
  public String multiply1(String num1, String num2) {
    if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
      return "0";
    }
    int nums[] = new int[num1.length() + num2.length()];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = 0;
    }
    for (int i = 0; i < num1.length(); i++) {
      for (int j = 0; j < num2.length(); j++) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        nums[i + j] = nums[i + j] + mul / 10;
        nums[i + j + 1] = nums[i + j + 1] + mul % 10;
      }
    }
    int carry = 0, i = nums.length - 1;
    while (i >= 0) {
      nums[i] += carry;
      carry = nums[i] / 10;
      nums[i] = nums[i] % 10;
      i--;
    }
    int j = 0;
    if (nums[0] == 0) {
      j++;
    }
    StringBuilder s = new StringBuilder();
    while (j < nums.length) {
      s.append(nums[j]);
      j++;
    }
    return s.toString();
  }
}
