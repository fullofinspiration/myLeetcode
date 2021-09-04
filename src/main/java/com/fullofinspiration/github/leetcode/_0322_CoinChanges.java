package com.fullofinspiration.github.leetcode;

import java.util.Arrays;

public class _0322_CoinChanges {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (coins == null || coins.length == 0) {
                return -1;
            }
            int[] ints = new int[amount + 1];
            for (int i = 1; i < ints.length; i++) {
                ints[i] = Integer.MAX_VALUE;
            }
            for (int i = 1; i < ints.length; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0 && ints[i - coin] != Integer.MAX_VALUE) {
                        ints[i] = Math.min(ints[i], 1 + ints[i - coin]);
                    }
                }
            }
            return ints[amount] == Integer.MAX_VALUE ? -1 : ints[amount];
        }
    }


    /**
     * 超时
     */
    class Solution0 {
        int minCount = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {
            if (coins.length == 0) {
                return -1;
            }
            Arrays.sort(coins);
            getCoinChangeSize(coins, amount, coins.length - 1, 0);
            return minCount == Integer.MAX_VALUE ? -1 : minCount;
        }

        private void getCoinChangeSize(int[] coins, int amount, int index, int count) {
            if (amount == 0) {
                String msg = getString(count, count, 0, coins[index], amount, amount, 0);
                System.out.println(msg);
                minCount = count;
                return;
            }
            if (amount < 0) {
                return;
            }
            int curElementCount = 0;
            int curSum = 0;
            while (curSum < amount && curElementCount + count < minCount - 1) {
                curSum += coins[index];
                curElementCount++;
            }
            if (curSum < amount) {
                return;
            }
            if (curSum == amount) {
                int curTotalCount = curElementCount + count;
                minCount = curTotalCount;
                String msg = getString(curTotalCount, count, curElementCount, coins[index], amount, amount, curSum);
                System.out.println(msg);
                return;
            }
            if (index == 0) {
                return;
            }

            while (curElementCount >= 0) {
                getCoinChangeSize(coins, amount - curSum, index - 1, count + curElementCount);
                curSum -= coins[index];
                curElementCount--;
            }
        }

        private String getString(int count, int prevCount, int curCount, int curValue,
                                 int amount, int prevAmount, int curAmount) {
            return String.format("Cur count: %s, prevCount: %s,curCount: %s,  cur value: %s, amount: %s," +
                            " prevAmount: %s, curAmount: %s",
                    count, prevCount, curCount, curValue, amount, prevAmount, curAmount);
        }
    }
}
