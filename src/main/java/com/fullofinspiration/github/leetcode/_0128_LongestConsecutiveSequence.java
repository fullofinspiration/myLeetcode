package com.fullofinspiration.github.leetcode;

/**
 * TreeMap<Integer, Integer> low2Size;
 * int max = 0;
 * for(int i=0;i<nums.size();i++){
 *    int size = 1;
 *    Entry<Integer,Integer> low = low2Size.getLower(nums[i]);
 *    if (low == null || low.getKey() + low.getValue()-1 < nums[i]) {
 *       Entry<Integer,Integer> high = low2Size.getHigher(nums[i]);
 *       if (high == null || high.getKey()-1> nums[i]) {
 *           low2Size.put(nums[i], 1);
 *       } else {
 *           size  = high +1;
 *           low2Size.put(nums[i], ++high);
 *           if (high > max) {
 *       }
 *    } else {
 *        if (low.getKey() + low.getValue - 1 >= nums[i]) {
 *            //看两个间断区间是否可以合并成一个区间
 *            if (low2Size.get(nums[i]) != null) {
 *                 size = low.getValue() + low2Size.get(nums[i]) +1;
 *                low2Size.put(low.getKey, size);
 *                low2Size.remove(nums[i]);
 *            } else {
 *                size = low.getValue + 1;
 *                low2Size.put(low.getKey, size);
 *            }
 *        } else {
 *            low2Size.put(nums[i], 1);
 *        }
 *    }
 *    return max;
 * }
 */
public class _0128_LongestConsecutiveSequence {
}
