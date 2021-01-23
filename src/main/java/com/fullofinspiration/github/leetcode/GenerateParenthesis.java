package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

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
