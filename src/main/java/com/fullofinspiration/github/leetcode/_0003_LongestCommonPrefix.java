package com.fullofinspiration.github.leetcode;

/**
 * medium
 */
public class _0003_LongestCommonPrefix {
  public static String longestCommonPrefix(String[] strs) {
    if (strs == null|| strs.length ==0) {
      return "";
    }
    String longestCommonPrefix = strs[0];
    for (int i = 1;i < strs.length;i++) {
      int equalIndex = -1;
      for (int j = 0;j<Math.min(strs[i].length(),longestCommonPrefix.length());j++) {
        if (strs[i].charAt(j)!=longestCommonPrefix.charAt(j)){
          break;
        }
        equalIndex = j;
      }
      if (equalIndex < 0) {
        return "";
      }
      longestCommonPrefix = longestCommonPrefix.substring(0,equalIndex+1);
    }
    return longestCommonPrefix;
  }
}
