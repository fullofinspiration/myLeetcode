package com.fullofinspiration.github.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class _0406_QueueReconstructionByHeight {
    /**
     * https://leetcode.com/problems/queue-reconstruction-by-height/solutions/89345/easy-concept-with-python-c-java-solution/comments/93971
     */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, ((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]));
            LinkedList<int[]> all = new LinkedList<>();
            for (int[] cur : people) {
                all.add(cur[1], cur);
            }
            return all.toArray(new int[people.length][2]);
        }
    }
}
