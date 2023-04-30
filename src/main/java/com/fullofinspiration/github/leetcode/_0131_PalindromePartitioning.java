package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0131_PalindromePartitioning {

    /**
     * 1 假如当前是[1,2,3] 则判断当前是否是回文子串，然后增加切割点,可以增加2个切割点：1|2 2|3
     * 入参不知道要怎么弄比较好
     * https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/?orderBy=most_votes
     * 每次新添加substring，长度由小到大，然后递归添加
     * 错误1： 应该是l++,hi--,写反了
     *
     */
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> all = new ArrayList<>();
            backtrace(all, s, new ArrayList<>(), 0);
            return all;
        }

        private void backtrace(List<List<String>> all, String s, List<String> tmpList, int idx) {
            if (idx > s.length() - 1) {
                all.add(new ArrayList<>(tmpList));
                return;
            }
            for (int i = idx + 1; i <= s.length(); i++) {
                String cur = s.substring(idx, i);
                if (!isPalindrome(cur)) {
                    continue;
                }
                tmpList.add(cur);
                backtrace(all, s, tmpList, i);
                tmpList.remove(tmpList.size() - 1);
            }
        }

        private boolean isPalindrome(String s) {
            if(s.length() == 0) {
                throw new IllegalStateException();
            }
            int l = 0, hi = s.length() - 1;
            while (l < hi) {
                if (s.charAt(l) != s.charAt(hi)) {
                    return false;
                }
                l++;
                hi--;
            }
            return true;
        }
    }
}
