package com.fullofinspiration.github.leetcode;


public class _0055_JumpGame {
    /**
     * https://leetcode.com/problems/jump-game/solutions/20900/simplest-o-n-solution-with-constant-space/?orderBy=most_votes
     * 找到第一个能跨越上一个节点的值，然后继续找，不需要找到多个这种节点
     * debug问题：
     * 终止条件写错了，应该为小于等于0
     */
    class Solution {
        public boolean canJump(int[] nums) {
            int last = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (i + nums[i] >= last) {
                    last = i;
                }
            }
            return last <= 0;
        }
    }

    /**
     * 节点若为0（节点范围 :[0, length-2]），则查找前一个节点能否跳过该节点，能跳过，则返回true，不能跳过，则返回false
     * 错误1： 落下了curIdx--导致没有触发找到第一个跳过去的条件
     * 错误2： 必须找到能跳过该节点的那个节点，所以循环条件应该是：curIdx + nums[curIdx] <= zeroIdx 而不是curIdx + nums[curIdx] < zeroIdx
     */
    class Solution02 {
        public boolean canJump(int[] nums) {
            int curIdx = nums.length - 2;
            while (true) {
                while (curIdx >= 0 && nums[curIdx] > 0) {
                    curIdx--;
                }
                if (curIdx < 0) {
                    return true;
                }
                int zeroIdx = curIdx;
                curIdx--;
                while (curIdx >= 0 && curIdx + nums[curIdx] <= zeroIdx) {
                    curIdx--;
                }
                if (curIdx < 0) {
                    return false;
                }
            }

        }
    }

    /**
     * 使用递归，任何一个返回true，则返回true，否则从另一条路继续寻找, 超出时间限制
     */
    class Solution01 {
        public boolean canJump(int[] nums) {
            return doCanJump(nums, 0);
        }

        private boolean doCanJump(int[] nums, int idx) {
            if (nums[idx] + idx >= nums.length - 1) {
                return true;
            }
            for (int i = 1; i <= nums[idx]; i++) {
                if (doCanJump(nums, idx + i)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 从头到尾，每次读取值后，在这个范围内寻找跳的最远的值（靠右的元素跳的长度+1），看最终是否能够跳到最后
     */
    class Solution00 {
        public boolean canJump(int[] nums) {
            return false;
        }
    }

}
