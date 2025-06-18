package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0022_GenerateParenthesis {
    /**
     * 开始时间：21：14
     * 结束时间: 21:28
     */
    class Solution {
        int n;
        List<String> all = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            this.n = n;
            backtrace("", 0, 0);
            return all;
        }

        private void backtrace(String curS, int leftCount, int rightCount) {
            if (leftCount > n) {
                return;
            }
            if (rightCount > n) {
                return;
            }
            if (curS.length() == n * 2) {
                all.add(curS);
                return;
            }
            backtrace(curS + "(", leftCount + 1, rightCount);
            if (leftCount > rightCount) {
                backtrace(curS + ")", leftCount, rightCount + 1);
            }
        }
    }

    /**
     * 递归，左括号，右括号次数：
     * 1 若左括号数量等于又括号，同时等于n，插入到结果中
     * 2 若当前左括号数量等于右括号数量，只能加左括号
     * 3 加左括号和右括号
     * 错误1：最多只能有n个左括号和右括号
     */
    class Solution01 {
        private final List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            doGenerateParenthesis(n, "", 0, 0);
            return res;
        }

        private void doGenerateParenthesis(int n, String cur, int left, int right) {
            if (n == left && left == right) {
                res.add(cur);
                return;
            }
            if (left < n) {
                doGenerateParenthesis(n, cur + "(", left + 1, right);
            }
            if (left > right) {
                doGenerateParenthesis(n, cur + ")", left, right + 1);
            }
        }
    }

    class Solution00 {
        public List<String> generateParenthesis(int n) {
            List<String> all = new ArrayList<>();
            LinkedList<Data> datas = new LinkedList<>();
            datas.add(new Data("(", 1, 0));
            while (!datas.isEmpty()) {
                Data data = datas.removeLast();
                if (data.leftSize == n && data.rightSize == n) {
                    all.add(data.value);
                } else {
                    if (data.leftSize < n) {
                        Data newData = new Data(data.value + "(", data.leftSize + 1, data.rightSize);
                        datas.add(newData);
                    }
                    if (data.rightSize < data.leftSize) {
                        Data newData = new Data(data.value + ")", data.leftSize, data.rightSize + 1);
                        datas.add(newData);
                    }
                }
            }
            return all;
        }

        private class Data {
            private String value;
            private int leftSize;
            private int rightSize;

            public Data(String value, int leftSize, int rightSize) {
                this.value = value;
                this.leftSize = leftSize;
                this.rightSize = rightSize;
            }
        }
    }

    /**
     * 递归
     */
    class Solution1 {
        List<String> all = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            buildParenthesis(n, 0, 0, "");
            return all;
        }

        private void buildParenthesis(int n, int leftSize, int rightSize, String string) {
            if (leftSize < rightSize) {
                return;
            }
            if (leftSize == n && rightSize == n) {
                all.add(string);
            }
            if (leftSize < n) {
                buildParenthesis(n, leftSize + 1, rightSize, string + "(");
            }
            if (rightSize < n) {
                buildParenthesis(n, leftSize, rightSize + 1, string + ")");
            }
        }
    }

    /**
     * 两次过，但是中间只调试了30s，我真是太牛逼了
     */
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        int open = 0, close = 0;
        List<String> result = new ArrayList<>();
        handleGenerateParenthesis(result, open, close, "", n);
        return result;
    }

    private static void handleGenerateParenthesis(List<String> result, int open, int close,
                                                  String curStr, int n) {
        if (curStr.length() == n * 2) {
            result.add(curStr);
            return;
        }
        if (open < n) {
            handleGenerateParenthesis(result, open + 1, close, curStr + "(", n);
        }
        if (open > close) {
            handleGenerateParenthesis(result, open + 1, close, curStr + "(", n);
        }
    }
}
