package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    String s = "pwwkew";
    System.out.println(lengthOfLongestSubstring(s));

  }

  //  public static int lengthOfLongestSubstring(String s) {
  //    if (s == null || s.length() <= 0) {
  //      return 0;
  //    }
  //    int maxLength = 0, curLength = 0, curBeginIndex = 0;
  //    for (int i = 0; i < s.length(); i++) {
  //      String curSubString = s.substring(curBeginIndex, i);
  //      String lastString = String.valueOf(s.charAt(i));
  //      if (curSubString.contains(lastString)) {
  //        int index = curSubString.indexOf(lastString) + curBeginIndex;
  //        curLength = i - index;
  //        curBeginIndex = index + 1;
  //      } else {
  //        curLength++;
  //        if (curLength > maxLength) {
  //          maxLength = curLength;
  //        }
  //      }
  //    }
  //    return maxLength;
  //  }

  //最笨的方法
  //  public static int lengthOfLongestSubstring(String s) {
  //    int n = s.length();
  //    Set<Character> set = new HashSet<Character>();
  //    int ans = 0, i = 0, j = 0;
  //    while (i < n && j < n) {
  //      // try to extend the range [i, j]
  //      if (!set.contains(s.charAt(j))) {
  //        set.add(s.charAt(j++));
  //        ans = Math.max(ans, j - i);
  //      } else {
  //        set.remove(s.charAt(i++));
  //      }
  //    }
  //    return ans;
  //  }

  //  public static int lengthOfLongestSubstring(String s) {
  //    if (s == null || s.length() <= 0) {
  //      return 0;
  //    }
  //    int res = 0, start = 0;
  //    Map<Character, Integer> map = new HashMap<Character, Integer>();
  //    for (int i = 0; i < s.length(); i++) {
  //      char c = s.charAt(i);
  //      if (map.containsKey(c)) {
  //        int index = map.get(c);
  //        if (start > index) {
  //          res = Math.max(res, i - start + 1);
  //        } else {
  //          start = index + 1;
  //        }
  //      } else {
  //        res = Math.max(res, i - start + 1);
  //      }
  //      map.put(c, i);
  //    }
  //    return res;
  //  }
  //


  //网上的人太牛逼了.
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() <= 0) {
      return 0;
    }
    int res = 0;
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0, j = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        j = Math.max(map.get(s.charAt(i)) + 1, j);
      }
      res = Math.max(i - j + 1, res);
      map.put(s.charAt(i), i);
    }
    return res;
  }

}
