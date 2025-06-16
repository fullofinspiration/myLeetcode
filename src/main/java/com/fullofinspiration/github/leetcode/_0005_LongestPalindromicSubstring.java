package com.fullofinspiration.github.leetcode;

import static java.lang.System.*;

/**
 * medium
 * 20230326 写了两种方法 total 1h
 */
public class _0005_LongestPalindromicSubstring {

    class Solution {
        int maxLen, lowIdx4Max;

        public String longestPalindrome(String s) {
            for (int i = 0; i < s.length(); i++) {
                findPalindrome(s, i, i);
                if (i > 0) {
                    findPalindrome(s, i - 1, i);
                }
            }
            return s.substring(lowIdx4Max, lowIdx4Max + maxLen );
        }

        private void findPalindrome(String s, int left, int right) {
            if (s.charAt(left) != s.charAt(right)) {
                return;
            }
            while (s.charAt(left) == s.charAt(right)) {
                int curLen = right - left + 1;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    lowIdx4Max = left;
                }

                if (left - 1 < 0 || right + 1 >= s.length()) {
                    return;
                }
                left--;
                right++;
            }
        }
    }

    class Solution00 {
        int allLow, allHigh;

        /**
         * 每个节点开始，都向两边遍历，若当前是回文，则记录
         * 需要注意，有奇数和偶数的回文，两种都需要考虑到
         * 时间复杂度O(n^2)
         * 空间复杂度O(1)
         */
        public String longestPalindrome(String s) {
            if (s.length() == 0) {
                return "";
            }
            for (int i = 0; i < s.length(); i++) {
                handleCur(s, i, i);
                handleCur(s, i, i + 1);
            }
            return s.substring(allLow, allHigh + 1);
        }

        private void handleCur(String s, int low, int high) {
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low > allHigh - allLow) {
                    allHigh = high;
                    allLow = low;
                }
                low--;
                high++;
            }
        }

    }

    /**
     * 这种方式不能很快想出来
     * 时间复杂度O(len^2)
     * 空间复杂度O(len^2)
     * dp
     * f(i,j): i开始j结尾的子串
     * f(i,j) = true if and only if f(i+1,j-1)=true and s[i]==s[j]
     * 错误1：i+1=j时需要判断两个字符串相等时为true
     * 错误2： corner case，结果中至少有一个字符串
     */
    class Solution03 {
        public String longestPalindrome(String s) {
            boolean[][] all = new boolean[s.length()][s.length()];
            String maxSubString = s.substring(0, 1);
            for (int i = s.length() - 1; i >= 0; i--) {
                all[i][i] = true;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j) && (i + 1 == j || all[i + 1][j - 1])) {
                        all[i][j] = true;
                        if (j - i + 1 > maxSubString.length()) {
                            maxSubString = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return maxSubString;
        }

    }

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 参考的别人的写法
     * 1 回文可能中间有一个值，可能中间有两个值
     * 2 每次从中间开始向两边延长，如果有比之前更大的值就记录
     * 3 遍历到最后得到最长的值
     */
    class Solution02 {
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
