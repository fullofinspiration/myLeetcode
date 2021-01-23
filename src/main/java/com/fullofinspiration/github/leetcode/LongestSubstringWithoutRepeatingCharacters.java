package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

    }

    //这个方法可能比较耗费性能
    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int maxLength = 0, curLength = 0, curBeginIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            String curSubString = s.substring(curBeginIndex, i);
            String lastString = String.valueOf(s.charAt(i));
            if (curSubString.contains(lastString)) {
                int index = curSubString.indexOf(lastString) + curBeginIndex;
                curLength = i - index;
                curBeginIndex = index + 1;
            } else {
                curLength++;
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
            }
        }
        return maxLength;
    }

    //这个方法也比较巧妙，i，j分别是左右两边的边界，最多遍历数组两次就可以得到最大值
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 和我的方法对比：我的方法移除了队列中的元素，但是可以不必这么做，只需要保存老的索引即可，不需要移除其中的全部元素
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int res = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (start > index) {
                    res = Math.max(res, i - start + 1);
                } else {
                    start = index + 1;
                }
            } else {
                res = Math.max(res, i - start + 1);
            }
            map.put(c, i);
        }
        return res;
    }


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
