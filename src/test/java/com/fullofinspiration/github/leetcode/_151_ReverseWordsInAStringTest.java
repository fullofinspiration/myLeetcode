package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _151_ReverseWordsInAStringTest {
    private static final _151_ReverseWordsInAString.Solution SOLUTION = new _151_ReverseWordsInAString().new Solution();

    @Test
    public void test00() {
        String res = SOLUTION.reverseWords("the sky is blue");
        String expect = "blue is sky the";
        Assert.assertEquals(expect, res);
    }

    @Test
    public void test01() {
        String res = SOLUTION.reverseWords("  hello world  ");
        String expect = "world hello";
        Assert.assertEquals(expect, res);
    }

    @Test
    public void test02() {
        String res = SOLUTION.reverseWords("a good   example");
        String expect = "example good a";
        Assert.assertEquals(expect, res);
    }

    @Test
    public void test03() {
        String res = SOLUTION.reverseWords("  Bob    Loves  Alice   ");
        String expect = "Alice Loves Bob";
        Assert.assertEquals(expect, res);
    }

    @Test
    public void test04() {
        String res = SOLUTION.reverseWords("Alice does not even like bob");
        String expect = "bob like even not does Alice";
        Assert.assertEquals(expect, res);
    }
}