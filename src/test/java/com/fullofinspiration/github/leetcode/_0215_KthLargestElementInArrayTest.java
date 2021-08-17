package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0215_KthLargestElementInArrayTest {

    private final _0215_KthLargestElementInArray.Solution SOLUTION = new _0215_KthLargestElementInArray().new Solution();

    @Test
    public void testFindKthLargest00() {
        int[] ints = {3, 2, 1, 5, 6, 4};
        int kthLargest = SOLUTION.findKthLargest(ints, 2);
        Assert.assertEquals(5, kthLargest);
    }

    @Test
    public void testFindKthLargest01() {
        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = SOLUTION.findKthLargest(ints, 4);
        Assert.assertEquals(4, kthLargest);
    }

}