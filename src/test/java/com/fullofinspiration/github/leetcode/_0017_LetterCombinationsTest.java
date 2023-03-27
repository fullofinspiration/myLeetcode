package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0017_LetterCombinationsTest extends TestCase {
    @Test
    public void test00() {
        _0017_LetterCombinations.Solution solution = new _0017_LetterCombinations().new Solution();
        List<String> expect = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> rst = solution.letterCombinations("23");
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0017_LetterCombinations.Solution solution = new _0017_LetterCombinations().new Solution();
        List<String> expect = Collections.emptyList();
        List<String> rst = solution.letterCombinations("");
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0017_LetterCombinations.Solution solution = new _0017_LetterCombinations().new Solution();
        List<String> expect = Arrays.asList("a", "b", "c");
        List<String> rst = solution.letterCombinations("2");
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }


}