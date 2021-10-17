package com.fullofinspiration.github.leetcode;

public class _0092_DecodeWays {
    /**
     * 每次有两种方式 1 走一步或者两步，如果下一位是0，只能连着走两步，如果两位加起来大于26，只能走一步
     * 故f(n) =
     * {
     * 1  if n = 0
     * 1  if n = 1 且当前值非0
     * f(n-1) + f(n-2) 如果当前位非0 且上一位非0且上一位加当前位小于等于26
     * 0 如果当前是0且上一位是0
     * f(n-2) 如果当前位是0
     * f(n-1) 如果当前位加上一位大于26，或者上一位是0
     * }
     * 遍历次数: n
     * 每次遍历长度
     */
    class Solution {
        public int numDecodings(String s) {
            int[] nums = new int[s.length() + 1];
            nums[0] = 1;
            if (s.charAt(0) - '0' == 0) {
                return 0;
            }
            nums[1] = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) - '0' == 0) {
                    if (s.charAt(i - 1) - '0' == 0 || isIllegalAfterAddPrevious(s, i)) {
                        return 0;
                    }
                    nums[i + 1] = nums[i - 1];
                } else if (s.charAt(i - 1) - '0' == 0 || isIllegalAfterAddPrevious(s, i)) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i + 1] = nums[i] + nums[i - 1];
                }
            }
            return nums[s.length()];
        }

        private boolean isIllegalAfterAddPrevious(String s, int i) {
            return  (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0' > 26;
        }
    }
}
