package com.fullofinspiration.github.learn;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ExactlyCompleteKnapsackTest extends TestCase {
    @Test
    public void test00() {
        ExactlyCompleteKnapsack.Solution solution = new ExactlyCompleteKnapsack().new Solution();
        int i = solution.maxWeight(3, Arrays.asList(2), Arrays.asList(3));
        Assert.assertEquals(-1, i);
    }

    @Test
    public void test01() {
        ExactlyCompleteKnapsack.Solution solution = new ExactlyCompleteKnapsack().new Solution();
        int i = solution.maxWeight(3, Arrays.asList(2, 4), Arrays.asList(3, 6));
        Assert.assertEquals(-1, i);
    }

    @Test
    public void test02() {
        ExactlyCompleteKnapsack.Solution solution = new ExactlyCompleteKnapsack().new Solution();
        int i = solution.maxWeight(3, Arrays.asList(2, 1), Arrays.asList(3, 6));
        Assert.assertEquals(18, i);
    }
}