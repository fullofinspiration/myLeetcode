package com.fullofinspiration.github;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 时间复杂度是O(n^3)，也就是只对最后一层做一个改进使得时间复杂度不是O(n^4),
 * 这里完全是参考三个数相加的例子，区别就是又多包裹了一层，注意while循环的判断是
 * 先判断lo < hi ，然后才能进行数组取值，否则会报错
 */
public class _018_4Sum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> lists = new LinkedList();
        if (num.length < 4) return lists;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                for (int j = i + 1; j < num.length - 2; j++) {
                    if (j == i + 1 || num[j] != num[j - 1]) {
                        int lo = j + 1, hi = num.length - 1;
                        while (lo < hi) {
                            if (num[i] + num[j] + num[lo] + num[hi] == target) {
                                lists.add(Arrays.asList(num[i], num[j], num[lo], num[hi]));
                                while (lo + 1 < hi && num[lo + 1] == num[lo])
                                    lo++;
                                while (lo < hi && num[hi - 1] == num[hi])
                                    hi--;
                                lo++;
                                hi--;
                            } else if (num[i] + num[j] + num[lo] + num[hi] < target)
                                lo++;
                            else
                                hi--;
                        }
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String args[]) {
        _018_4Sum sum = new _018_4Sum();
        int[] num = {0, 0, 0, 0};
        int target = 0;
        System.out.println(sum.fourSum(num, target));

    }
}
