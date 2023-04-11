package com.fullofinspiration.github.leetcode;


public class _0033_SearchRotatedSortedArray {
    /**
     * 性能差点，如果不存在，每次要遍历所有的值
     */
    class Solution {
        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (inRange(nums, low, mid, target)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        private boolean inRange(int[] nums, int low, int high, int target) {
            if (nums[low] <= nums[high]) {
                return target >= nums[low] && target <= nums[high];
            }
            return !(target > nums[high] && target < nums[low]);
        }
    }

    /**
     * mid=(low+high) / 2
     * low, mid not exist && mid+1,high {
     * <p>
     * }
     * if nums[low]==target: return idx
     * if nums[low] < nums[high] && (target < nums[low] || target > nums[high]) return false
     * if nums[low] > nums[high] && target >high && target < low: return false
     * if first not exist: 遍历 second
     * if second not exist: 遍历 first
     * 错误1： 笔误，notExist（）第4行应该是nums[low] < nums[high],写反了写成了nums[low] > nums[high]
     * 错误2：只有一个元素时notExist需要判断当前元素是否等于当前值，如果不属于，肯定是不存在的
     * notExist看起来太抽象了，还是使用inRange来实现
     */
    class Solution4 {
        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (notExist(nums, low, mid, target) && notExist(nums, mid + 1, high, target)) {
                    return -1;
                }
                if (notExist(nums, low, mid, target)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        private boolean notExist(int[] nums, int low, int high, int target) {
            if (low > high) {
                return true;
            }
            if (nums[low] <= nums[high] && (target < nums[low] || target > nums[high])) {
                return true;
            }
            if (nums[low] > nums[high] && target > nums[high] && target < nums[low]) {
                return true;
            }
            return false;
        }
    }

    /**
     * 1 找到第一个值，该值切分了左边和右边：
     * 1）比较左右节点，假如left<right 则为left
     * 2）选取mid，假如mid>left: left=mid+1,否则right=mid-1
     * 2 分别寻找left和right
     * 分步有点多，先放弃
     */
    class Solution3 {
        public int search(int[] nums, int target) {
            return -1;
        }
    }

    class Solution2 {
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                boolean inRange = inRange(nums, low, mid, target);
                if (inRange) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        private boolean inRange(int[] nums, int low, int high, int target) {
            System.out.println(String.format("Low: %s, high: %s, target: %s.", low, high, target));
            if (nums[low] <= nums[high]) {
                return nums[low] <= target && nums[high] >= target;
            }
            return target >= nums[low] || target <= nums[high];
        }
    }

    /**
     * 自己写的其他解法有空再看
     */
    class Solution1 {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                if (nums[low] <= nums[high]) {
                    if (target < nums[low] || target > nums[high]) {
                        return -1;
                    }
                    int midIndex = (low + high) / 2;
                    if (nums[midIndex] == target) {
                        return midIndex;
                    } else if (nums[midIndex] > target) {
                        high = midIndex - 1;
                    } else {
                        low = midIndex + 1;
                    }
                } else {
                    if (target > nums[high] && target < nums[low]) {
                        return -1;
                    }
                    int midIndex = (low + high) / 2;
                    if (nums[midIndex] == target) {
                        return midIndex;
                    }
                    if (nums[low] < nums[midIndex] && target >= nums[low] && target < nums[midIndex]) {
                        high = midIndex - 1;
                    } else if (nums[low] > nums[midIndex] && (target >= nums[low] || target < nums[midIndex])) {
                        high = midIndex - 1;
                    } else {
                        low = midIndex + 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main1(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        search(array, 0);
    }

    /**
     * 我的解法很繁琐，非常费时间，容易出错，根本没必要写两个函数，因为第一个
     * 函数已经有了二分查找的思想，所以没必要写两个
     * 而答案中的解法真的一点不拖泥带水
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target && nums[low] <= target) {
                return binarySearch(nums, target, low, mid - 1);
            }
            if (nums[mid] > target && nums[low] >= target) {
                if (nums[low] > nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (nums[mid] < target && nums[high] >= target) {
                return binarySearch(nums, target, mid + 1, high);
            }
            if (nums[mid] < target && nums[high] <= target) {
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }


}
