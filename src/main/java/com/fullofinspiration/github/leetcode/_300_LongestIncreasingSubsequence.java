package com.fullofinspiration.github.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//todo 没有完成，后面继续
public class _300_LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            List<Data> datas = new LinkedList<>();
            Data curMaxData = new Data(nums[0], nums[0], 1);
            datas.add(curMaxData);
            for (int i = 1; i < nums.length; i++) {
                int curValue = nums[i];
                Iterator<Data> iterator = datas.iterator();
                while (iterator.hasNext()) {
                    Data curData = iterator.next();
                    if (curData.highValue < curValue) {
                        curData.length++;
                        curData.highValue = curValue;
                    }
                    if (curData.length > curMaxData.length) {
                        curMaxData = curData;
                    }
                    if (curData.length < curMaxData.length && curData.lowValue > curMaxData.lowValue) {
                        iterator.remove();
                    }
                }
                datas.add(new Data(curValue, curValue, 1));
            }
            return curMaxData.length;
        }

        private class Data {
            private final int lowValue;
            private int highValue;
            private int length;
            public Data(int lowValue, int highValue, int length) {
                this.lowValue = lowValue;
                this.highValue = highValue;
                this.length = length;
            }
        }
    }
}
