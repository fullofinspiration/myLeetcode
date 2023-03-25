package com.fullofinspiration.github.learn;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CompleteKnapsackTest extends TestCase {

    @Test
    public void test00() {
        CompleteKnapsack.Solution solution = new CompleteKnapsack().new Solution();
        int i = solution.maxWeight(10, Arrays.asList(1, 2), Arrays.asList(3, 2));
        Assert.assertEquals(30, i);
    }

}