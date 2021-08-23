package com.fullofinspiration.github.leetcode;

import static java.lang.System.*;

/**
 * 写出结果后耗时过长，最终参考的历史提交的算法
 * medium
 */
public class _0005_LongestPalindromicSubstring {
    /**
     * 参考的别人的写法
     * 1 回文可能中间有一个值，可能中间有两个值
     * 2 每次从中间开始向两边延长，如果有比之前更大的值就记录
     * 3 遍历到最后得到最长的值
     */
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int curMaxLength = Math.max(getMaxLength(s, i, i), getMaxLength(s, i, i + 1));
                if (curMaxLength > end - start + 1) {
                    start = i - (curMaxLength - 1) / 2;
                    end = i + curMaxLength / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int getMaxLength(String s, int start, int end) {
            if (start < 0 || end >= s.length()) {
                return 0;
            }
            while (start >= 0 && end < s.length() && start <= end && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            return end - start - 1;
        }
    }

    /**
     * 本机跑了5min没有结果，原因可能是1 代码耗费性能，耗时很长，2可能代码有bug："babaddtattarrattatddetartrateedredividerb"
     */
    class Solution1 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            return getLargestPalindrom(s, 0, s.length() - 1);
        }

        public String getLargestPalindrom(String s, int start, int end) {
            if (isPalindrom(s, start, end)) {
                return s.substring(start, end + 1);
            }
            String firstLargestPalindrom = getLargestPalindrom(s, start + 1, end);
            String secondLargestPalindrom = getLargestPalindrom(s, start, end - 1);
            if (firstLargestPalindrom.length() > secondLargestPalindrom.length()) {
                return firstLargestPalindrom;
            } else {
                return secondLargestPalindrom;
            }
        }

        public boolean isPalindrom(String s, int start, int end) {
            while (start <= end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        out.println(s.length());
        String result = longestPalindrome(s);
        out.println(result.length());
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
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int preLen = getMaxLength(s, i, i);
            int afterLen = getMaxLength(s, i, i + 1);
            int curMaxLen = Math.max(preLen, afterLen);
            if (curMaxLen > end - begin + 1) {
                begin = i - (curMaxLen - 1) / 2;
                end = i + curMaxLen / 2;
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
