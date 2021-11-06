package com.fullofinspiration.github.leetcode;

/**
 * hard
 * todo impl
 */
public class _0010_RegularExpressionMatching {
    class Solution {
        public boolean isMatch(String target, String regex) {
            if (target == null || target.length() == 0) {
                return isZeroMatch(regex);
            }
            int targetIndex = 0;
            int regexIndex = 0;
            while (true) {
                if (regexIndex == regex.length()) {
                    if (targetIndex != target.length()) {
                        return false;
                    }
                    return true;
                }
                if (regex.length() - 1 == regexIndex || isLetter(regex.charAt(regexIndex + 1))) {
                    if (target.charAt(targetIndex) != regex.charAt(regexIndex)) {
                        return false;
                    }
                    targetIndex++;
                    regexIndex++;
                    continue;
                }
                if (allMatch(regex.substring(regexIndex, regexIndex + 1))) {
                    return true;
                }
                break;
            }
            return false;
        }

        private void test(String first, String second) {
            if (isAnyMatch(first) && isOneMatch(second)) {
                String s;
                int i = 0;
                if (second.charAt(0) == first.charAt(0)) {
//                    if (s.charAt())
                }
            }
        }

        private boolean isAnyMatch(String s) {
            if (s.length() != 2) {
                throw new IllegalArgumentException();
            }
            return isLetter(s.charAt(0)) && isDot(s.charAt(1));
        }

        private boolean isOneMatch(String s) {
            if (s.length() != 2) {
                throw new IllegalArgumentException();
            }
            return isLetter(s.charAt(0)) && isStar(s.charAt(1));
        }

        private boolean isZeroMatch(String regex) {
            return regex == null || "".equals(regex) || ".*".equals(regex);
        }

        private boolean isLetter(char s) {
            return s >= 'a' && s <= 'z';
        }

        private boolean allMatch(String s) {
            return ".*".equals(s);
        }

        private boolean isStar(char c) {
            return c == '*';
        }

        private boolean isDot(char c) {
            return c == '.';
        }
    }
}
