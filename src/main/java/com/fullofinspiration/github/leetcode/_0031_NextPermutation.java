package com.fullofinspiration.github.leetcode;

public class _0031_NextPermutation {
    /**
     * bug1: swap函数i++,j--后i!=j永远都不成立了
     * 1 脑海里默想 [1,2,3],[2,1,3],[2,3,1],[3,1,2],[3,2,1]，
     * 2 如果所有数字是从大到小排列，则刚刚好
     * 3 如果不是从大到小排列，找到第一个小的值，然后从右边（从大到小）找到第一个比该值大的值，并交换
     * 4 右侧是从大到小排列，改为从小到大排列
     */
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int firstSmallValIdx;
            for (firstSmallValIdx = len - 2; firstSmallValIdx >= 0; firstSmallValIdx--) {
                if (nums[firstSmallValIdx] < nums[firstSmallValIdx + 1]) {
                    break;
                }
            }
            findFirstBiggerValAndSwap(nums, firstSmallValIdx, firstSmallValIdx + 1);
            revert(nums, firstSmallValIdx + 1);
        }

        private void findFirstBiggerValAndSwap(int[] nums, int firstSmallValIdx, int beginIdx) {
            if (firstSmallValIdx < 0) {
                return;
            }
            int swapIdx = nums.length - 1;
            while (swapIdx > beginIdx) {
                if (nums[swapIdx] > nums[firstSmallValIdx]) {
                    break;
                }
                swapIdx--;
            }
            swap(nums, firstSmallValIdx, swapIdx);

        }

        private void revert(int[] arr, int low) {
            int i = low, j = arr.length - 1;
            while (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


    /**
     * 1 找到逆序排列的长度
     * 2 找到第一个非逆序的数字
     * 3 找到第一个比该数大的元素
     * 4 将该数字放在该位置
     * 5 剩下元素由倒序改成正序
     * <p>
     * 错误1 ：终止条件low + 1 == nums.length 而不是low + 1 == nums.length+1
     * 错误2：找到第一个比指定节点大的值计算的有问题：
     * if (nums[low] > swappedVal && (low + 1 == nums.length  || nums[low + 1] < swappedVal)) {
     * swap(nums, low, swappedIdx);
     * }
     * 此时如果low节点是第一个比他大的值，会交换失败
     * 错误3：
     * if (nums[i] > swappedVal && (i == nums.length - 1 || nums[i + 1] <= swappedVal)) 而不是if (nums[i] > swappedVal && (i == nums.length - 1 || nums[i + 1] < swappedVal))
     * 想错了终止条件
     * 错误4： 不是错误，但是增加了代码复杂度，比错误更严重：
     * 只需要写成：nums[i] > swappedVal 而不是这么一大坨： nums[i] > swappedVal && (i == nums.length - 1 || nums[i + 1] <= swappedVal）
     * 错误5： 虽然增加变量swappedVal可以减少一层缩进，但是更繁琐，可以去掉
     */
    class Solution02 {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int swappedIdx = nums.length - 2;
            while (swappedIdx >= 0) {
                if (nums[swappedIdx] < nums[swappedIdx + 1]) {
                    break;
                }
                swappedIdx--;
            }

            if (swappedIdx != -1) {
                for (int i = nums.length - 1; i > swappedIdx; i--) {
                    if (nums[i] > nums[swappedIdx]) {
                        swap(nums, i, swappedIdx);
                        break;
                    }
                }
            }

            int low = swappedIdx + 1, high = nums.length - 1;
            while (low <= high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }

        private void swap(int[] input, int i, int j) {
            int tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
        }
    }

    class Solution01 {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int targetIdx = nums.length - 2;
            while (targetIdx >= 0 && nums[targetIdx] >= nums[targetIdx + 1]) {
                targetIdx--;
            }
            if (targetIdx >= 0) {
                for (int j = nums.length - 1; j > targetIdx; j--) {
                    if (nums[j] > nums[targetIdx]) {
                        swap(nums, targetIdx, j);
                        break;
                    }
                }
            }
            int low = targetIdx + 1;
            int high = nums.length - 1;
            while (low < high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }

        private void swap(int[] nums, int targetIdx, int j) {
            int tmp = nums[j];
            nums[j] = nums[targetIdx];
            nums[targetIdx] = tmp;
        }
    }

    /**
     * 通过二分查找的方式没有必要，因为更换顺序的操作时间复杂度是O(n),如果用二分，因为必须更换顺序，所以总的时间复杂度没有变，仍待是O(n)
     * 改方法只是做一个尝试，没有跑ut
     */
    class Solution2 {
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] > nums[i + 1]) {
                    continue;
                }
                //find first value which is grater than curValue
                int tmp = nums[i];
                int firstGraterThanCurValueIndex = findFirstGraterThanTarget(nums, tmp, i + 1, nums.length - 1);
                nums[i] = nums[firstGraterThanCurValueIndex];
                nums[firstGraterThanCurValueIndex] = tmp;
                //颠倒所有数据
                reverseAll(nums, i, nums.length - 1);
                return;
            }
            //此时说明当前是逆序排列，颠倒所有数据
            reverseAll(nums, 0, nums.length - 1);
        }

        public void reverseAll(int[] all, int start, int end) {
            while (start < end) {
                int tmp = all[start];
                all[start] = all[end];
                all[end] = tmp;
                start++;
                end--;
            }
        }

        /**
         * @param nums   逆序排列
         * @param target 目标值
         * @param start  开始索引
         * @param end    结束索引
         * @return 目标索引
         */
        public int findFirstGraterThanTarget(int[] nums, int target, int start, int end) {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] > target) {
                    if (mid == end || nums[mid + 1] <= target) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    end = mid - 1;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    class Solution1 {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int lessThanNextIndex = nums.length - 2;
            while (lessThanNextIndex >= 0 && nums[lessThanNextIndex] >= nums[lessThanNextIndex + 1]) {
                lessThanNextIndex--;
            }
            int j = nums.length - 1;
            while (lessThanNextIndex >= 0 && j > lessThanNextIndex && nums[j] <= nums[lessThanNextIndex]) {
                j--;
            }
            if (lessThanNextIndex != -1) {
                int temp = nums[lessThanNextIndex];
                nums[lessThanNextIndex] = nums[j];
                nums[j] = temp;
            }

            int low = lessThanNextIndex + 1;
            int high = nums.length - 1;
            while (low < high) {
                int temp = nums[low];
                nums[low++] = nums[high];
                nums[high--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int maxIndex = nums.length - 1;
        int minIndex = maxIndex;
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex--;
            } else {
                int j = maxIndex;
                while (j < minIndex && nums[j + 1] > nums[i]) {
                    j++;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                break;
            }
        }
        while (maxIndex < minIndex) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[minIndex];
            nums[minIndex] = temp;
            maxIndex++;
            minIndex--;
        }
    }

}
