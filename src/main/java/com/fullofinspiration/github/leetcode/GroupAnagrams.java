package com.fullofinspiration.github.leetcode;

import java.util.*;

public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> listMap = new HashMap<>();
    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String mapKey = String.valueOf(chars);
      if (!listMap.containsKey(mapKey)) {
        listMap.put(mapKey, new ArrayList<>());
      }
      listMap.get(mapKey).add(s);
    }
    return new ArrayList<>(listMap.values());
  }

}
