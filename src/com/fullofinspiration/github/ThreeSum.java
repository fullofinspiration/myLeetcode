package com.fullofinspiration.github;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 去重复判断很繁琐，首先在第一个for循环做第一个数字必须为非重复值，然后在while循环中，如果
 * 有满足条件的值，为了保证第二个值也是非重复的，还要做第二个值是非重复的判断
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            //因为此算法是三个数相加为0
            if (num[i] > 0) break;
            if (i == 0 || num[i] != num[i - 1]) {
                int lo = i + 1, hi = num.length - 1, sum = -num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (num[lo + 1] == num[lo] && lo + 1 < hi) lo++;
                        while (num[hi - 1] == num[hi] && hi - 1  > lo) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] > sum) hi--;
                    else lo++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(nums));
    }
}