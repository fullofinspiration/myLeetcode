package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhenpeng Zhang on 2021/1/23.
 */
public class LongestNonRepeatableLength {

    public static void main(String[] args) {
        LongestNonRepeatableLength longestLengthCalculator = new LongestNonRepeatableLength();
        int aab = longestLengthCalculator.lengthOfLongestSubString("aab");
        System.out.println(aab);
        int pwwkew = longestLengthCalculator.lengthOfLongestSubString("pwwkew");
        System.out.println(pwwkew);
        int abcabcbb = longestLengthCalculator.lengthOfLongestSubString("abcabcbb");
        System.out.println(abcabcbb);
        int bbbbb = longestLengthCalculator.lengthOfLongestSubString("bbbbb");
        System.out.println(bbbbb);


    }

    /**
     * 只需要保存是否有出现过的元素，同时和旧的最大值相对比
     */
    public int lengthOfLongestSubString(String str) {
        Map<Character, Integer> all = new HashMap<>();
        int maxLength = 0;
        int curStart = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        for (int index = 0; index < str.length(); index++) {
            char curChar = str.charAt(index);
            if (all.containsKey(curChar) && curStart <= all.get(curChar)) {
                curStart = all.get(curChar) + 1;
            }
            maxLength = Math.max(maxLength, index - curStart + 1);
            all.put(curChar, index);
        }
        return maxLength;
    }
}
