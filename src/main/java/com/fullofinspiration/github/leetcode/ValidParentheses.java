package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
  public static void main(String[] args) {
    String s = "([)]";
    isValid(s);
  }

  public static boolean isValid(String s) {
    if (s== null || s.length() == 0) {
      return true;
    }
    LinkedList<Character> linkedList = new LinkedList<>();
    Map<Character,Character> stringMap = new HashMap<>();
    stringMap.put('[',']');
    stringMap.put('(',')');
    stringMap.put('{','}');
    for (int i=0;i < s.length();i++) {
      char c = s.charAt(i);
      if (stringMap.containsKey(c)) {
        linkedList.add(c);
        continue;
      }
      if (stringMap.containsValue(c)) {
        if (!linkedList.isEmpty()) {
          Character character = linkedList.removeLast();
          if (stringMap.get(character) != c) {
            return false;
          }
        } else {
          return false;
        }
      }
    }
    if (linkedList.isEmpty()) {
      return true;
    }
    return false;
  }
}
