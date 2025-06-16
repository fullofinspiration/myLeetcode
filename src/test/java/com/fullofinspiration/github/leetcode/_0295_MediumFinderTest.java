package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0295_MediumFinderTest {
    @Test
    public void test00() {
        _0295_MediumFinder.MedianFinder finder = new _0295_MediumFinder().new MedianFinder();
        finder.addNum(-1);
        finder.addNum(-2);
        double median = finder.findMedian();
        Assert.assertEquals(-1.5,median, 0.0001);


    }

}