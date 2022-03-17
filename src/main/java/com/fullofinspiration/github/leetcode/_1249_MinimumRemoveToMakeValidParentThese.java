package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/28 11:58 AM
 */
public class _1249_MinimumRemoveToMakeValidParentThese {

  class Solution {

    public String minRemoveToMakeValid(String s) {
      if (s == null || s.length() == 0) {
        return "";
      }
      LinkedList<Integer> checkedParentTheses = new LinkedList<>();
      Set<Integer> removedIdx = new HashSet<>();
      for (int i = 0; i < s.length(); i++) {
        char curValue = s.charAt(i);
        if (curValue != '(' && curValue != ')') {
          continue;
        }
        if (curValue == '(') {
          checkedParentTheses.add(i);
        } else if (checkedParentTheses.isEmpty()) {
          removedIdx.add(i);
        } else {
          checkedParentTheses.removeLast();
        }
      }
      removedIdx.addAll(checkedParentTheses);
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        if (!removedIdx.contains(i)) {
          builder.append(s.charAt(i));
        }
      }
      return builder.toString();
    }
  }
}
