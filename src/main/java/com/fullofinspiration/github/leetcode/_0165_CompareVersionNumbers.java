package com.fullofinspiration.github.leetcode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _0165_CompareVersionNumbers {
    class Solution {
        public int compareVersion(String version1, String version2) {
            if (version1 == null && version2 == null) {
                return 0;
            }
            List<Integer> first = version1 == null ? Collections.emptyList() : Stream.of(version1.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> second = version2 == null ? Collections.emptyList() : Stream.of(version2.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
            int firstIndex = 0;
            int secondIndex = 0;
            while (firstIndex < first.size() || secondIndex < second.size()) {
                if (firstIndex < first.size() && secondIndex < second.size()) {
                    Integer firstVal = first.get(firstIndex);
                    Integer secondVal = second.get(secondIndex);
                    if (firstVal > secondVal) {
                        return 1;
                    }
                    if (firstVal.equals(secondVal)) {
                        firstIndex++;
                        secondIndex++;
                        continue;
                    }
                    return -1;
                }
                if (firstIndex < first.size()) {
                    if (first.get(firstIndex) > 0) {
                        return 1;
                    }
                    firstIndex++;
                    continue;
                }

                if (second.get(secondIndex) > 0) {
                    return -1;
                }
                secondIndex++;
            }
            return 0;
        }
    }
}
