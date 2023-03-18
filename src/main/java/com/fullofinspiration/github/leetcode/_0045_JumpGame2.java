package com.fullofinspiration.github.leetcode;

public class _0045_JumpGame2 {

    /**
     * https://leetcode.com/problems/jump-game-ii/solutions/18023/single-loop-simple-java-solution/comments/18012
     * 1 得到某个节点前能走的最远距离
     * 2 如果到达了上个节点走的最远距离，count++, prev更新为当前的最远距离
     * 错误
     * 原因1：终止条件应该是：i < nums.length-1 而不是 i< nums.length
     */
    class Solution {
        public int jump(int[] nums) {
            int prevMax = 0;
            int count = 0;
            int curMax = 0;
            for (int i = 0; i < nums.length-1; i++) {
                curMax = Math.max(curMax, i + nums[i]);
                if (i == prevMax) {
                    count++;
                    prevMax = curMax;
                }
            }
            return count;
        }
    }

    /**
     * 每次跳到一个位置后，选择该位置的值向右的值中最大的值即可，最大值计算：值元素+索引位置(右边值比左边值大1)
     * debug
     * 错误1：终止条件后没有return
     * 错误2：递归条件没有加一:应该是 doJump(nums, idx + i, count + 1) 而不是： doJump(nums, idx, count + 1)
     * 错误3：应该写最小值而不是最大值
     * 错误4： cornor case： 如果数组长度为1，则返回0
     */
    class Solution00 {
        int min = Integer.MAX_VALUE;

        public int jump(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            doJump(nums, 0, 0);
            return min;
        }

        private void doJump(int[] nums, int idx, int count) {
            if (idx >= nums.length - 1) {
                throw new IllegalStateException();
            }
            if (nums[idx] + idx >= nums.length - 1) {
                min = Math.min(count + 1, min);
                return;
            }
            for (int i = 1; i <= nums[idx]; i++) {
                doJump(nums, idx + i, count + 1);
            }
        }
    }
}
