package com.fullofinspiration.github.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法的典型应用（我理解的回溯法就是不停的递归）
 * 这个算法不是自己想出来的，是抄的
 */
public class _0020_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> lists = new LinkedList<>();
        backtrace(lists, "", 0, 0, 0, n);
        return lists;
    }

    public void backtrace(List<String> list, String string, int total, int left, int right, int max) {
        if (total == max * 2) {
            list.add(string);
            return;
        }
        if (left < max)
            backtrace(list, string + "(", total + 1, left + 1, right, max);
        if (right < left)
            backtrace(list, string + ")", total + 1,left, right + 1, max);

    }
    public static void main(String[] args) {
        _0020_GenerateParenthesis a = new _0020_GenerateParenthesis();
        List<String> lists = a.generateParenthesis(3);
        for (String list : lists)
            System.out.println(list);
    }
}
