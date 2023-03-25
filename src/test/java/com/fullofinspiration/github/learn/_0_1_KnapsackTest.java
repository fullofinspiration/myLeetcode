package com.fullofinspiration.github.learn;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0_1_KnapsackTest extends TestCase {
    @Test
    public void test00() {
        _0_1_Knapsack.Solution solution = new _0_1_Knapsack().new Solution();
        int i = solution.maxWeight(50,  Arrays.asList(10, 20, 30),Arrays.asList(60, 100, 120));
        Assert.assertEquals(220, i);
    }
}