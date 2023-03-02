package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _0027_RemoveElementTest extends TestCase {
    @Test
    public void test00() {
        _0027_RemoveElement.Solution solution = new _0027_RemoveElement().new Solution();
        int[] input = {3, 2, 2, 3};
        int size = solution.removeElement(input, 3);
        int[] expect = {2, 2, 2, 3};
        Assert.assertEquals(2, size);

        boolean equal = ListUtil.equal(toList(expect), toList(input));
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0027_RemoveElement.Solution solution = new _0027_RemoveElement().new Solution();
        int[] input = {0, 1, 2, 2, 3, 0, 4, 2};
        int size = solution.removeElement(input, 2);
        int[] expect = {0, 1, 3, 0, 4, 0, 4, 2};
        Assert.assertEquals(5, size);
        boolean equal = ListUtil.equal(toList(expect), toList(input));
        Assert.assertTrue(equal);
    }

    private List<Integer> toList(int[] input) {
        return Arrays.stream(input).boxed().collect(Collectors.toList());
    }

}