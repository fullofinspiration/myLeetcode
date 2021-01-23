package com.fullofinspiration.github.leetcode;

import java.util.Iterator;
import java.util.LinkedHashSet;

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

    public int lengthOfLongestSubString(String str) {
        //记录老的最长记录，如果新的记录大于老的，更新记录，使用linkedHashMap
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int maxLength = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        int curLength = 0;
        int index = 0;

        while (index < str.length()) {
            if (set.contains(str.charAt(index))) {
                boolean hasRemoved = false;
                int removeCount = 0;
                Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()) {
                    Character next = iterator.next();
                    if (hasRemoved) {
                        break;
                    } else {
                        removeCount++;
                        iterator.remove();
                        if (next.equals(str.charAt(index))) {
                            hasRemoved = true;
                        }
                    }
                }
                curLength -= removeCount;
            }
            set.add(str.charAt(index));
            curLength++;
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            index++;
        }
        return maxLength;
    }
}
