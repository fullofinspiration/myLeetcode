package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {

  public static void main(String[] args) {
    String s = convert("PAYPALISHIRING", 3);
    System.out.println(s);
  }

  /**
   * 本人解法：缺陷： 1 list中没有必要嵌套list，而是嵌套一个stringbuilder
   *
   * 2 没有检查创建的行数（s如果很短的话行数有可能小于numRows）
   *
   * 3 没有必要用stringbuffer，stringbuffer是线程安全的，而stringbuilder是非线程安全的，可以更快
   *
   * 4 思路闭塞，我只看到是“Z”字形的，其实从输入输出参数来看可以是“W”类型的，即向下向上可以更灵活一点， 答案中的转换更加灵活
   */
  public static String convert1(String s, int numRows) {
    if (s == null || s.length() == 0) {
      return "";
    }
    int circleLength = numRows * 2 - 2;
    if (circleLength == 0) {
      return s;
    }
    List<List<Character>> allList = new ArrayList<List<Character>>();
    for (int i = 0; i < numRows; i++) {
      List<Character> characterList = new ArrayList<Character>();
      allList.add(characterList);
    }
    for (int i = 0; i < s.length(); i++) {
      int tmpIndex = i % circleLength;
      int listIndexToAdd = tmpIndex < numRows ? tmpIndex : circleLength - tmpIndex;
      List<Character> list = allList.get(listIndexToAdd);
      list.add(s.charAt(i));
    }
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < numRows; i++) {
      List<Character> list = allList.get(i);
      list.forEach(curChar -> stringBuffer.append(curChar));
    }
    return stringBuffer.toString();
  }

  public static String convert(String s, int numRows) {
    if (s == null || s.length() == 0) {
      return s;
    }
    if (numRows == 1) {
      return s;
    }
    int rowNumber = s.length() > numRows ? numRows:s.length();

    List<StringBuilder> list = new ArrayList<>();
    for (int i = 0; i < rowNumber;i ++) {
      StringBuilder stringBuilder = new StringBuilder();
      list.add(stringBuilder);
    }
    boolean isDown = false;
    int curRow = 0;
    for (int i = 0;i < s.length();i ++) {
      list.get(curRow).append(s.charAt(i));
      if (curRow == 0 || curRow == numRows - 1) {
        isDown = ! isDown;
      }
      curRow = isDown ? curRow +1 :curRow -1;
    }
    StringBuilder allStringBuilder = new StringBuilder();
    for (StringBuilder stringBuilder : list) {
      allStringBuilder.append(stringBuilder);
    }
    return allStringBuilder.toString();
  }
}
