package com.fullofinspiration.github.leetcode;

public class _0034_FirstAndLastPositionOfElementInSortedArray {
    /**
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/504484/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/comments/1989894/
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int low = findMid(nums, target, true);
            int high = findMid(nums, target, false);
            return new int[]{low, high};
        }

        private int findMid(int[] nums, int target, boolean backword) {
            int ret = -1;
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    ret = mid;
                    if (backword) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ret;
        }
    }

    /**
     * 普通二分查找到target
     * 最左边：nums[i] == target && (i-1<0 || nums[i-1]<target): return idx
     * nums[mid]>=target: high=mid-1
     * 错误1：( (mid == 0) || nums[mid - 1] < target)) 开始写的是mid == 0) || nums[mid - 1] < target，没有加括号括起来，导致mid==0时仍然执行后面语句，最终指针越界
     * 可优化的点：left的值需要大于等于target right需要小于等于target，这样在不符合条件时可以早点退出
     */
    class Solution3 {
        public int[] searchRange(int[] nums, int target) {
            int left = findLeft(nums, target);
            int right = findRight(nums, target);
            return new int[]{left, right};
        }

        private int findLeft(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high && nums[low] <= target && nums[high] >= target) {
                int mid = (low + high) / 2;
                if (nums[mid] == target && ((mid == 0) || nums[mid - 1] < target)) {
                    return mid;
                }
                if (nums[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        private int findRight(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high && nums[low] <= target && nums[high] >= target) {
                int mid = (low + high) / 2;
                if (nums[mid] == target && ((mid == nums.length - 1) || nums[mid + 1] > target)) {
                    return mid;
                }
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }
    }

    class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int first = findFirst(nums, target);
            if (first == -1) {
                return new int[]{-1, -1};
            }

            int last = findLast(nums, target);
            return new int[]{first, last};
        }

        private int findFirst(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = (low + high) / 2;
            while (low <= high && nums[low] <= target && nums[high] >= target) {
                mid = (low + high) / 2;
                if (nums[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (nums[mid] == target) {
                return mid;
            }
            return -1;
        }

        private int findLast(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = (low + high) / 2;
            while (low <= high && nums[low] <= target && nums[high] >= target) {
                mid = (low + high) / 2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return mid;
        }
    }

    /**
     * 边界判断过于复杂
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14734/Easy-java-O(logn)-solution
     * 1 find lower和find higer临时变量过多，一个方法中过于混乱，所以放在多个方法中可以很清晰
     * 2 终止条件 1） low > hig 2） low 和high相等
     * 3 注意返回值不是low or high，而是mid
     */
    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int lower = findLower(nums, target);
            if (lower == -1) {
                return new int[]{-1, -1};
            }
            int higher = findHigher(nums, target);
            return new int[]{lower, higher};
        }

        private int findHigher(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = -1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (nums[mid] == target) {
                    if (low == high || low + 1 == high) {
                        if (nums[high] == target) {
                            return high;
                        }
                        return low;
                    }
                    low = mid;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return mid;
        }

        private int findLower(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = (low + high) / 2;
            while (low <= high) {
                mid = (low + high) / 2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] == target) {
                    if (low == high) {
                        return low;
                    }
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (nums[mid] == target) {
                return mid;
            }
            return -1;
        }
    }

    /**
     * 一把过，我真是太牛逼了,但是方法有点问题，太过复杂了
     */
    public int[] searchRange1(int[] nums, int target) {
        int i = 0, j = nums.length - 1, targetIndex = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                targetIndex = mid;
                break;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (targetIndex == -1) {
            return new int[]{-1, -1};
        }
        int m = targetIndex, n = targetIndex;
        while (m >= 0 && nums[m] == target) {
            m--;
        }
        while ((n < nums.length && nums[n] == target)) {
            n++;
        }
        return new int[]{m + 1, n - 1};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        searchRange(nums, 8);

    }

    /**
     * 方法太过巧妙，应该时长复习一下对于low和high还有条件判断的东西，真的是太巧妙了
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = binarySearch(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return result;
        }
        int right = binarySearch(nums, target, false);
        return new int[]{left, right - 1};
    }

    public static int binarySearch(int[] nums, int target, boolean isLeft) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || (nums[mid] == target && isLeft)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
