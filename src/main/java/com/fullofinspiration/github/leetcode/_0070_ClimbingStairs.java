package com.fullofinspiration.github.leetcode;


public class _0070_ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int first = 1;
            int second = 1;
            n -= 1;
            while (n-- > 0) {
                int tmp = first;
                first = second;
                second += tmp;
            }
            return second;
        }
    }

    class Solution03 {
        public int climbStairs(int n) {
            int[] all = new int[n + 1];
            all[0] = 1;
            all[1] = 1;
            for (int i = 2; i <= n; i++) {
                all[i] = all[i - 1] + all[i - 2];
            }
            return all[n];
        }
    }

    /**
     * 使用递归比较好实现些
     * curStairCount:当前楼梯高度
     * 1 定义方法countPath(int curStairCount):
     * if (curStairCount == count):
     * return 1;
     * elif (curStairCount > count):
     * return 0;
     * else:
     * return countPath(curStairCount+1) + countPath(curStairCount+2)
     */
    class Solution02 {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int first = 1;
            int second = 2;
            n -= 2;
            while (n-- > 0) {
                int temp = first;
                first = second;
                second += temp;
            }
            return second;
        }
    }

    /**
     * 超时
     */
    class Solution1 {
        public int climbStairs(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
