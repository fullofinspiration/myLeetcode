package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/28 10:54 AM
 */
public class _0692_WordFrequencyCounter {

  class Solution {

    public List<String> topKFrequent(String[] words, int k) {
      Map<String, Integer> word2Frequency = new HashMap<>();
      for (String word : words) {
        if (word2Frequency.containsKey(word)) {
          word2Frequency.put(word, word2Frequency.get(word) + 1);
        } else {
          word2Frequency.put(word, 1);
        }
      }
      PriorityQueue<FrequencyInfo> frequencyInfoQueue = new PriorityQueue<>(
          (a, b) -> {
            int delta = b.frequency - a.frequency;
            if (delta != 0) {
              return delta;
            }
            return a.value.compareTo(b.value);
          });
      for (String word : word2Frequency.keySet()) {
        frequencyInfoQueue.add(new FrequencyInfo(word, word2Frequency.get(word)));
      }
      List<String> rst = new ArrayList<>();
      while (k-- > 0) {
        FrequencyInfo freqInfo = frequencyInfoQueue.poll();
        rst.add(freqInfo.value);
      }
      return rst;
    }

    private class FrequencyInfo {

      public String value;
      public int frequency;

      public FrequencyInfo(String value, int frequency) {
        this.value = value;
        this.frequency = frequency;
      }

      @Override
      public String toString() {
        return "FrequencyInfo{" +
            "value='" + value + '\'' +
            ", frequency=" + frequency +
            '}';
      }
    }
  }

}
