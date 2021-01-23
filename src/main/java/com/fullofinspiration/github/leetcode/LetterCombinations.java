package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }

  //我的方法可以，但是太繁琐了，应该用队列和数组结合
  public static List<String> letterCombinations1(String digits) {
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

  static List<String> addDigit(List<String> prevResult, String appendString) {
    List<String> curResult = new ArrayList<>();
    for (int i = 0; i < appendString.length(); i++) {
      for (String prevString : prevResult) {
        curResult.add(prevString + appendString.charAt(i));
      }
    }
    return curResult;
  }


  /**
   * 这个方法太牛逼了怪不得得到这么多的赞，首先索引映射多加了个0和1，可以直接根据字符串在-'0'得到对应索引
   * 然后将result初始化时多加了一个空字符串，便于和当前长度相比较，从而只使用一个linkedList就可以将所有的
   * 值都放入其中，真是太巧妙了
   * @param digits
   * @return
   */
  public static List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() <=0) {
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
