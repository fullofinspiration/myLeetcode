package com.fullofinspiration.github.leetcode;

public class _0031_NextPermutation {
  class Solution {
    public void nextPermutation(int[] nums) {
      if (nums == null || nums.length <= 1) {
        return;
      }
      int targetIdx = nums.length - 2;
      while (targetIdx >= 0 && nums[targetIdx] >= nums[targetIdx+1]) {
        targetIdx--;
      }
      if (targetIdx >= 0) {
        for(int j = nums.length - 1;j > targetIdx; j--) {
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
            for(int i = nums.length - 2;i >= 0;i--) {
                if (nums[i] > nums[i+1]) {
                    continue;
                }
                //find first value which is grater than curValue
                int tmp = nums[i];
                int firstGraterThanCurValueIndex = findFirstGraterThanTarget(nums,tmp,i+1, nums.length-1);
                nums[i] = nums[firstGraterThanCurValueIndex];
                nums[firstGraterThanCurValueIndex] = tmp;
                //颠倒所有数据
                reverseAll(nums, i, nums.length-1);
                return;
            }
            //此时说明当前是逆序排列，颠倒所有数据
          reverseAll(nums, 0, nums.length-1);
        }

        public void reverseAll(int[] all, int start,int end) {
          while (start< end) {
            int tmp = all[start];
            all[start] = all[end];
            all[end] = tmp;
            start++;
            end--;
          }
        }
      /**
       *
       * @param nums 逆序排列
       * @param target 目标值
       * @param start 开始索引
       * @param end 结束索引
       * @return 目标索引
       */
        public int findFirstGraterThanTarget(int[] nums, int target, int start, int end) {
          while (start<=end) {
            int mid=(start+end) / 2;
            if (nums[mid] > target) {
              if (mid==end || nums[mid+1] <=target) {
                return mid;
              } else {
                start=mid+1 ;
              }
            }else {
              end = mid-1;
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
