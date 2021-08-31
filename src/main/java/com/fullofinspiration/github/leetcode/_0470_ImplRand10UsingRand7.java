package com.fullofinspiration.github.leetcode;

import java.util.Random;

public class _0470_ImplRand10UsingRand7 {
    class Solution extends SolBase {
        public int rand10() {
            SolBase solBase = new SolBase();
            int i;
            int j;
            while (true) {
                i = 7 * (solBase.rand7() - 1);
                j = solBase.rand7() - 1;
                if (i + j < 40) {
                    break;
                }
            }
            return (i + j) % 10 + 1;
        }
    }
}

class SolBase {
    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
