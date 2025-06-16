package com.fullofinspiration.github.leetcode;

public class _0075_SortColors {
    /**
     * 三个颜色各自计数后直接改写
     * 下面讲解三指针法：
     * 1 p0：放置0的下个位置 p1：放置1的下个位置
     * 需要注意，当前位置i>=p0, i>=p1
     * i=p0,p1时是否需要额外处理？
     * i=p0, 表明当前没有1，2，arr[i]=0时， 此时交换等于没有交换，然后将i，j同时加一,
     * arr[i]=1时 此时交换等于没有交换，将j+1
     * 正常情况下，arr[p0]=1 arr[p1]=2
     */
    class Solution {
        public void sortColors(int[] nums) {
            int p0 = 0, p1 = 0;
            for (int i = 0; i < nums.length; i++) {
                int curVal = nums[i];
                if (curVal == 0) {
                    swap(nums, p0, i);
                    if (p0 < p1) {
                        swap(nums, p1, i);
                    }
                    p0++;
                    p1++;
                    continue;
                }
                if (curVal == 1) {
                    swap(nums, p1, i);
                    p1++;
                }
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
