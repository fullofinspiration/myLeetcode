package com.fullofinspiration.github;

import java.util.LinkedList;
import java.util.List;

/**
 * linkedList具有队列的属性，使用LinkedList.add()可以在队列尾部添加值，
 * 使用LinkedList.remove()可以在头部删除值。只不过和书上说的队列有点不同，因为
 * 书上的队列是在索引低的地方插入的，而这里是在索引值高的地方插入的
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return result;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            while(result.peek().length() == i) {
                String s = result.remove();
                for (char c : mapping[digits.charAt(i) - '0'].toCharArray()) {
                    result.add(s + c);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String string = "234";
        List<String> list = letterCombinations.letterCombinations(string);
        System.out.println(list);

    }
}
