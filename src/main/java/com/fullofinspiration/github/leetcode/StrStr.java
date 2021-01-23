package com.fullofinspiration.github.leetcode;

public class StrStr {

  public static void main(String[] args) {
    String s = "mississippi", s1 = "issip";
    strStr(s, s1);
  }

  //最终通过了，但是方法太复杂了，面试的时候根本写不出来.
  public static int strStr1(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    int first = -1, curIndex = -1, nextFirst = -1;
    int index = 0;
    while (index < haystack.length()) {
      if (curIndex == needle.length() - 1) {
        return first;
      }
      if (haystack.charAt(index) == needle.charAt(0) && first != -1 && nextFirst == -1) {
        nextFirst = index;
      }
      if (haystack.charAt(index) == needle.charAt(curIndex + 1)) {
        if (curIndex == -1) {
          first = index;
        }
        curIndex++;
        index++;
      } else {
        curIndex = -1;
        first = nextFirst;
        if (nextFirst >= 0) {
          index = nextFirst + 1;
          curIndex = 0;
          nextFirst = -1;
        } else {
          ++index;
        }
      }
    }
    if (curIndex != needle.length() - 1) {
      return -1;
    }
    return first;
  }

  public static int strStr(String haystack, String needle) {
    for (int i = 0; i < haystack.length(); i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (i + j == haystack.length()) {
          return -1;
        }
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
        if (j == needle.length() - 1) {
          return i;
        }
      }
    }
    if (needle.length() ==0) {
      return 0;
    }
    return -1;
  }

}
