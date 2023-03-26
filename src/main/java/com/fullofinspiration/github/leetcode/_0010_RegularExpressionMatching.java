package com.fullofinspiration.github.leetcode;

/**
 * hard 调试失败，明天再看
 */
public class _0010_RegularExpressionMatching {
    /**
     * f(i,j) 代表第正则前i个字符对前j个是否匹配
     * f(i,j)=f(i-1,j-1) if i='any character' && regex(i)= target(j)
     * f(i,j)=f(i-1,j-1) if regex(i)='.'
     * f(i,j)= f(i-2,j) || f(i,j-1) if regex(i)=='*'&& (target(j)== regex(i-1) || regex(i-1)=='.'), 否则为false
     * 初始条件：为true
     * debug错误
     * 1：索引从0开始后，应该是i < regex.length() 而不是i <= regex.length()
     * 2: 遗漏了all[0][0]=true
     * 3: 条件遗漏了，f(i,j) =f(i-2,j)|| f(i,j-1) 需要有从小于i的地方推演过来，否则一直是false
     * 4：索引写错了， 应该是：all[i + 1][j + 1] = all[i + 1][j] || all[i - 1][j + 1]而不是all[i + 1][j + 1] = all[i + 1][j] || all[i - 2][j + 1]
     * 6: 条件少写了一个，f(i-2,j): 0个匹配 f(i-1,j) 1个匹配 f(i,j-1) 多个匹配(这里太难写出来了，参考的：https://leetcode.com/problems/regular-expression-matching/solutions/5651/easy-dp-java-solution-with-detailed-explanation/?orderBy=most_votes)
     */
    class Solution {
        public boolean isMatch(String target, String regex) {
            boolean[][] all = new boolean[regex.length() + 1][target.length() + 1];
            all[0][0] = true;
            for (int i = 0; i < regex.length(); i++) {
                    for (int j = 0; j < target.length(); j++) {
                        char regexC = regex.charAt(i);
                        if ((regexC >= 'a' && regexC <= 'z' && regexC == target.charAt(j))
                                || regexC == '.') {
                            all[i + 1][j + 1] = all[i][j];
                        } else if (regexC == '*' &&
                                (regex.charAt(i - 1) == target.charAt(j) || regex.charAt(i - 1) == '.')) {
                            all[i + 1][j + 1] = all[i + 1][j] || all[i - 1][j + 1] || all[i - 1][j];
                        }
                    }
            }
            return all[regex.length()][target.length()];
        }
    }

    class Solution00 {
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
