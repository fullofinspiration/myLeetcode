package com.fullofinspiration.github.leetcode;

public class _0053_MaximumSubArray {

    /**
     * 分而治之：
     * max = Math.max(left, right, midLeft+midRight)
     * stackoverflowerror:
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            return doGetMaxSubArr(nums, 0, nums.length - 1);
        }

        private int doGetMaxSubArr(int[] nums, int low, int high) {
            if (low == high) {
                return nums[low];
            }
            int mid = (low + high) / 2;
            int leftMax = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = mid; i >= low; i--) {
                sum += nums[i];
                leftMax = Math.max(leftMax, sum);
            }
            int rightMax = Integer.MIN_VALUE;
            sum = 0;
            for (int i = mid + 1; i <= high; i++) {
                sum += nums[i];
                rightMax = Math.max(rightMax, sum);
            }
            int max = Math.max(doGetMaxSubArr(nums, low, mid), doGetMaxSubArr(nums, mid + 1, high));
            return Math.max(max, leftMax + rightMax);
        }
    }

    /**
     * 参考solution00
     * 出错位置1：prevMax = nums[0]笔误写成了prevMax = nums[1]
     */
    class Solution02 {
        public int maxSubArray(int[] nums) {
            int prevMax = nums[0];
            int curSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (curSum < 0) {
                    curSum = nums[i];
                } else {
                    curSum += nums[i];
                }
                prevMax = Math.max(prevMax, curSum);
            }
            return prevMax;
        }
    }

    /**
     * 1 if (nums[i] + prevNegative>0){
     * update sum+=nums[i]+prevNegative
     * prevNegative=0
     * } else {
     * prevNegative+=nums[i];
     * }
     * 问题1： 结果中至少有一个元素
     * 问题2：结果中至少有一个元素，但不一定是第一个元素
     * 问题3: 只有在total是负数时才需要更新total，否则不需要更新total
     * 问题4：if total + prevNeg<0 && cur > total total = cur
     * 问题5: 最终放弃，错误太多，原因是当前累计应该勇哥
     */
    class Solution01 {
        public int maxSubArray(int[] nums) {
            int total = Integer.MIN_VALUE;
            int prevNegative = 0;
            for (int num : nums) {
                // 替换total
                if ((total < 0 || total + prevNegative < 0) && num > total) {
                    total = num;
                    prevNegative = 0;
                    continue;
                }
                if (num > 0 && total + prevNegative > 0) {
                    total += prevNegative + num;
                    prevNegative = 0;
                } else {
                    prevNegative += num;
                }

            }
            return total;
        }
    }

    /**
     * 方式1：
     * 1 遍历当前数组到末尾
     * 2 设置oldLow，遍历过程中如果当前加和小于oldMaxSum(因为有可能所有值都是小于0的，所以不能用0作为舍弃old low index的条件)，则舍弃old low，
     * 直到遍历到结尾
     */
    class Solution00 {
        public int maxSubArray(int[] nums) {
            int preMax = nums[0];
            int curSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (curSum < 0) {
                    curSum = nums[i];
                } else {
                    curSum += nums[i];
                }
                if (curSum > preMax) {
                    preMax = curSum;
                }
            }
            return preMax;
        }
    }
}
