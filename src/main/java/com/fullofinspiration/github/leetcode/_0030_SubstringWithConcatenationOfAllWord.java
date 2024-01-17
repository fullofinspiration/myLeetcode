package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0030_SubstringWithConcatenationOfAllWord {
    class Solution {
        List<Integer> rst = new ArrayList<>();
        public List<Integer> findSubstring(String s, String[] words) {
            Map<String,Integer> all = new HashMap<>();
            for(String word: words) {
                if (all.containsKey(word)) {
                    all.put(word, all.get(word)+1);
                    continue;
                }
                all.put(word,1);
            }
            int lenPerWord = words[0].length();
            int satisfiedLen = lenPerWord * words.length;
            for(int i=0; i< s.length();i++) {
                String substring = s.substring(i);
                if (isSatisfied(substring,new HashMap<>(all),lenPerWord, satisfiedLen )) {
                    rst.add(i);
                }
            }
            return rst;
        }
        private boolean isSatisfied(String s, Map<String, Integer> all, int lenPerWord,int  satisfiedLen) {

            if (satisfiedLen > s.length()) {
                return false;
            }


            s = s.substring(0, satisfiedLen);
            for(int i=0;i<s.length()/lenPerWord;i++) {
                String cur = s.substring(i * lenPerWord, (i + 1) * lenPerWord);
                if (!all.containsKey(cur) || all.get(cur)<1) {
                    return false;
                }
                Integer curCount = all.get(cur);
                all.put(cur, curCount-1);
            }
            return all.values().stream().noneMatch(value->value >0);
        }
    }

}
