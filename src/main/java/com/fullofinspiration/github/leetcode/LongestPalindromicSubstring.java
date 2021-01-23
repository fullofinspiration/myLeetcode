package com.fullofinspiration.github.leetcode;

/**
 * 1 回文可能中间有一个值，可能中间有两个值 2 如何得到最长的回文子字符（） 已经找到思路： i：1 ~ n-1 j: i+1 ~ n-1 有一个最大长度的list i递增，j递减
 * 依次比较，记录当前值 若有合适的值，break，i++ 若没有，i++ 直到遍历结束
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    String s =
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    System.out.println(s.length());
    String result = longestPalindrome(s);
    System.out.println(result.length());
  }

  //代码没问题，但是对于他的某些案例（比如只有中间的值不一样，其他部分的值都一样）,求解过慢，导致超时，只能用他提供的按照中心点来求比较快.
  //  public static String longestPalindrome(String s) {
  //    if (s == null || s.length() == 0) {
  //      return s;
  //    }
  //    int begin = 0, end = 0;
  //    for (int i = 0; i < s.length(); i++) {
  //      for (int j = s.length() - 1; j >= i; j--) {
  //        int k = i;
  //        int l = j;
  //        while (l > k) {
  //          if (s.charAt(k) != s.charAt(l)) {
  //            break;
  //          } else {
  //            l--;
  //            k++;
  //          }
  //        }
  //        if (l <= k && (j - i > end - begin)) {
  //          begin = i;
  //          end = j;
  //        }
  //      }
  //    }
  //    return s.substring(begin, end + 1);
  //  }

  //方法很巧
  public static String longestPalindrome(String s) {
    if (s == null || s.length() <= 0) {
      return s;
    }
    int begin = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int preLen = getMaxLength(s, i, i);
      int afterLen = getMaxLength(s, i, i + 1);
      int curMaxLen = Math.max(preLen, afterLen);
      if (curMaxLen > end - begin + 1) {
        begin = i - (curMaxLen-1) /2;
        end = i + curMaxLen /2;
      }
    }
    return s.substring(begin, end + 1);
  }

  static int getMaxLength(String s, int prev, int after) {
    if (s.length() == 0) {
      return 0;
    }
    while (prev >= 0 && after < s.length() && s.charAt(prev) == s.charAt(after)) {
      prev--;
      after++;
    }

    return after - prev - 1;
  }


}
