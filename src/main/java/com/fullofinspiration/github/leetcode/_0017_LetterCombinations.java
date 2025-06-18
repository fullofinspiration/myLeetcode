package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0017_LetterCombinations {
    /**
     * 开始时间:22:43
     * 结束时间 23:06
     */
    class Solution {
        private String digits;
        private final List<String> rets = new ArrayList<>();
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return new ArrayList<>();
            }
            this.digits = digits;
            backtrace(0, "");
            return rets;
        }

        private void backtrace(int i, String cur) {
            if (cur.length() == digits.length()) {
                rets.add(cur);
                return;
            }
            if (i > digits.length() - 1) {
                return;
            }
            String all = mapping[digits.charAt(i) - '0'];
            for (char c : all.toCharArray()) {
                backtrace(i + 1, cur + c);
            }
        }
    }

    /**
     * idx2Str 使用递归
     * 每次string等于约定长度则返回，否则遍历下一个所有索引
     * 错误1： 影射关系写错了，idx是digits索引，idx->char->integer
     * 错误2：如果是空字符串，返回空数组
     */
    class Solution02 {
        private String digits;
        private Map<Integer, String> mapping;
        private List<String> rst = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return Collections.emptyList();
            }
            mapping = new HashMap<>();
            mapping.put(2, "abc");
            mapping.put(3, "def");
            mapping.put(4, "ghi");
            mapping.put(5, "jkl");
            mapping.put(6, "mno");
            mapping.put(7, "pqrs");
            mapping.put(8, "tuv");
            mapping.put(9, "wxyz");
            this.digits = digits;
            getCombination("", 0);
            return rst;
        }

        private void getCombination(String cur, int idx) {
            if (cur.length() == digits.length()) {
                rst.add(cur);
                return;
            }
            String s = mapping.get(Integer.parseInt(String.valueOf(digits.charAt(idx))));
            for (int i = 0; i < s.length(); i++) {
                getCombination(cur + s.charAt(i), idx + 1);
            }
        }
    }

    /**
     * by others，首先索引映射多加了个0和1，可以直接根据字符串在-'0'得到对应索引
     * 然后将result初始化时多加了一个空字符串，便于和当前长度相比较，从而只使用一个linkedList就可以将所有的
     * 值都放入其中，真是太巧妙了
     */
    class Solution01 {
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() <= 0) {
                return new LinkedList<>();
            }
            LinkedList<String> result = new LinkedList<>();
            String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            result.add("");
            for (int i = 0; i < digits.length(); i++) {
                while (result.peek().length() == i) {
                    String curString = result.remove();
                    for (char c : mapping[digits.charAt(i) - '0'].toCharArray()) {
                        result.add(curString + c);
                    }
                }
            }
            return result;
        }
    }


    //我的方法可以，但是太繁琐了，应该用队列和数组结合
    class Solution00 {
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }
            List<String> numberCharList = new ArrayList<>();
            numberCharList.add("abc");
            numberCharList.add("def");
            numberCharList.add("ghi");
            numberCharList.add("jkl");
            numberCharList.add("mno");
            numberCharList.add("pqrs");
            numberCharList.add("tuv");
            numberCharList.add("wxyz");
            List<String> result = new ArrayList<>();
            String[] strings = numberCharList.get(digits.charAt(0) - '0' - 2).split("");
            result.addAll(Arrays.asList(strings));

            for (int i = 1; i < digits.length(); i++) {
                result = addDigit(result, numberCharList.get(digits.charAt(i) - '0' - 2));
            }
            return result;

        }

        List<String> addDigit(List<String> prevResult, String appendString) {
            List<String> curResult = new ArrayList<>();
            for (int i = 0; i < appendString.length(); i++) {
                for (String prevString : prevResult) {
                    curResult.add(prevString + appendString.charAt(i));
                }
            }
            return curResult;
        }
    }


}
