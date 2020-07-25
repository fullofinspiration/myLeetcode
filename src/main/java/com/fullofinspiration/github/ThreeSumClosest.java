package com.fullofinspiration.github;

import java.util.Arrays;

/**
 * 直接用三个数的和与要比较的值相比较，如果大于1，就将大的值向左移动，否则
 * 就将较小的值向右移动
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int closetNumber = num[0] + num[1] + num[num.length - 1];
        for (int i = 0; i < num.length; i++) {
            int lo = i + 1, hi = num.length - 1;
            while (lo < hi) {
                int total = num[i] + num[lo] + num[hi];
                if (total - target > 0) hi--;
                else if (total - target < 0) lo++;
                else return target;
                if (Math.abs(total - target) < Math.abs(closetNumber - target))
                    closetNumber = total;
            }
        }
        return closetNumber;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int num = threeSumClosest.threeSumClosest(nums, 1);
        System.out.println(num);
    }
}
