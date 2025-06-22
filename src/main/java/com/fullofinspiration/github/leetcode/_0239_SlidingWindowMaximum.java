package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0239_SlidingWindowMaximum {
    /**
     * @see _0239_SlidingWindowMaximum.Solution00
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] leftMaxes = new int[nums.length];
            int[] rightMaxes = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i % k == 0) {
                    leftMaxes[i] = nums[i];
                    continue;
                }
                leftMaxes[i] = Math.max(nums[i], leftMaxes[i - 1]);
            }
            rightMaxes[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                if (i % k == 0) {
                    rightMaxes[i] = nums[i];
                    continue;
                }
                rightMaxes[i] = Math.max(rightMaxes[i], nums[i]);
            }
            int[] rets = new int[nums.length - k + 1];
            for (int i = 0; i < rets.length; i++) {
                rets[i] = Math.max(rightMaxes[i], leftMaxes[i + k - 1]);
            }
            return rets;
        }
    }

    /**
     * @see _0239_SlidingWindowMaximum.Solution02
     */
    class Solution03 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }
            if (k > nums.length) {
                throw new IllegalArgumentException();
            }
            List<Integer> all = new ArrayList<>();

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int i = 0; i < k - 1; i++) {
                queue.offer(new int[]{nums[i], i});
            }
            for (int i = k - 1; i < nums.length; i++) {
                queue.offer(new int[]{nums[i], i});
                while (queue.peek()[1] <= i - k) {
                    queue.poll();
                }
                all.add(queue.peek()[0]);
            }
            return all.stream().mapToInt(a -> a).toArray();
        }
    }

    /**
     * error：
     * 1） 结果的长度第一次写成了k，应该是nums.length-k+1
     * 2) 第二次遍历应该从k-1开始，并且在取出元素时，需要判断堆是否为空
     */
    class Solution02 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] rst = new int[nums.length - k + 1];
            int idx = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                }
                return a[1] - b[1];
            });
            for (int i = 0; i < k - 1; i++) {
                queue.offer(new int[]{nums[i], i});
            }
            for (int i = k - 1; i < nums.length; i++) {
                while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                    queue.poll();
                }
                queue.offer(new int[]{nums[i], i});
                rst[idx++] = queue.peek()[0];
            }
            return rst;
        }
    }

    /**
     * 新建最大堆，每次取出第一个元素
     * 1 遍历前k个元素
     * 2 最大值返回
     * 3 直到遍历所有元素
     * 时间复杂度构建： klogk，每次删除：k 每次插入：logk 插入次数n 故
     * 时间复杂度大致为k^2, 空间复杂度为O(k)
     * 出问题：
     * 1 k条件应该是k>nums.length，而不是k>=nums.length
     * 2 添加元素的前提是堆中元素数量等于k而不是每次都添加
     * 3 queue.remove会移除所有等于改数字的元素，需要只删除一个，故需要自己写迭代方法
     * 4 自己写的迭代方法忘记break
     * 5 每次都删除，每次遍历时间都很长，不使用这种方案
     */
    class Solution01 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k < 1 || k > nums.length) {
                throw new IllegalArgumentException();
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a).reversed());
            List<Integer> rst = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
                if (queue.size() < k) {
                    continue;
                }
                if (queue.size() > k) {
                    Iterator<Integer> iterator = queue.iterator();
                    while (iterator.hasNext()) {
                        Integer next = iterator.next();
                        if (next == nums[i - k]) {
                            iterator.remove();
                            break;
                        }
                    }
                }
                rst.add(queue.peek());
            }
            return rst.stream().mapToInt(a -> a).toArray();
        }
    }

    /**
     * 真的绝，这个方法，时间复杂度O(n)，每k个一组，分别求得k个一组从左到当前最大值，从右到当前最大值，然后在求得其中较大的值
     */
    class Solution00 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] leftMax = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i % k == 0) {
                    leftMax[i] = nums[i];
                } else {
                    leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
                }
            }
            int[] rightMax = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                if ((i + 1) % k == 0 || i == nums.length - 1) {
                    rightMax[i] = nums[i];
                } else {
                    rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
                }
            }
            int[] rst = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length - k + 1; i++) {
                rst[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
            }
            return rst;
        }
    }
}
