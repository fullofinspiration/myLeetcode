package com.fullofinspiration.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _0395_DecodeChar {
    /**
     * https://leetcode.cn/problems/decode-string/solutions/264391/zi-fu-chuan-jie-ma-by-leetcode-solution/comments/2266624/
     */
    /**
     * 当不包含中括号时，解析出数字有点麻烦，写不出来了
     */
    class Solution {
        public String decodeString(String s) {
            StringBuilder curSb = new StringBuilder();
            int curCount = 0;
            Deque<Integer> countStack = new ArrayDeque<>();
            Deque<String> prevStringStack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    curCount = curCount * 10 + c - '0';
                } else if (c == '[') {
                    prevStringStack.push(curSb.toString());
                    curSb = new StringBuilder();
                    countStack.push(curCount);
                    curCount = 0;
                } else if (c == ']') {
                    StringBuilder temp = new StringBuilder(prevStringStack.pop());
                    Integer count = countStack.pop();
                    for (int i = 0; i < count; i++) {
                        temp.append(curSb);
                    }
                    curSb = new StringBuilder();
                    curSb.append(temp);
                } else {
                    curSb.append(c);
                }
            }
            return curSb.toString();
        }
    }

    class WrongSolution {

        public String decodeString(String s) {
            StringBuilder sb = new StringBuilder();
            Queue<Character> indexStack = new ArrayDeque<>();
            int numberBeginIdx;
            int numberEndIdx = -1;
            int charBeginIdx = -1;
            int charEndIdx = -1;
            int curStart = 0;
            while (curStart < s.length()) {
                char curVal = s.charAt(curStart);
                if (curVal < '0' && curVal > '9') {
                    return "";
                }
                numberBeginIdx = curStart;
                for (int j = curStart; j < s.length(); j++) {
                    if (j == '[') {
                        numberEndIdx = j - 1;
                        charBeginIdx = j + 1;
                    } else if (j == ']') {
                        charEndIdx = j - 1;
                        curStart = j + 1;
                        break;
                    }
                }
                int curCount = Integer.parseInt(s.substring(numberBeginIdx, numberEndIdx + 1));
                String value = s.substring(charBeginIdx, charEndIdx + 1);
                for (int i = 0; i < curCount; i++) {
                    sb.append(value);
                }
            }
            return sb.toString();
        }
    }
}
