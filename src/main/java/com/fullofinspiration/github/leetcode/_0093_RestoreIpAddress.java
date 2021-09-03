package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _0093_RestoreIpAddress {
    class Solution {
        private List<String> all = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.length() > 12) {
                return Collections.emptyList();
            }
            buildIp(new ArrayList<>(), s, 0);
            return all;
        }

        private void buildIp(List<Integer> subList, String s, int cursor) {
            if (cursor >= s.length()) {
                return;
            }
            if (subList.size() == 3) {
                if (s.charAt(cursor) == '0') {
                    if (cursor == s.length() - 1) {
                        subList.add(0);
                        all.add(buildIp(subList));
                    }
                    return;
                }
                long value = Long.parseLong(s.substring(cursor));
                if (value > 255) {
                    return;
                }
                subList.add((int) value);
                all.add(buildIp(subList));
                return;
            }
            if (s.charAt(cursor) == '0') {
                subList.add(0);
                buildIp(subList, s, cursor + 1);
                return;
            }
            int endIndex = cursor + 1;
            while (endIndex <= s.length()) {
                long value = Long.parseLong(s.substring(cursor, endIndex));
                if (value > 255) {
                    return;
                }
                ArrayList<Integer> newList = new ArrayList<>(subList);
                newList.add((int) value);
                buildIp(newList, s, endIndex);
                endIndex++;
            }
        }

        private String buildIp(List<Integer> ip) {
            return ip.stream().map(String::valueOf).collect(Collectors.joining("."));
        }
    }
}
