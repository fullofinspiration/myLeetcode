package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class _0049_GroupAnagramsTest extends TestCase {

    @Test
    public void test00() {
        _0049_GroupAnagrams.Solution solution = new _0049_GroupAnagrams().new Solution();
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(input);
        List<String> expect1 = ImmutableList.of("bat");
        List<String> expect2 = ImmutableList.of("nat", "tan");
        List<String> expect3 = ImmutableList.of("ate", "eat", "tea");
        List<List<String>> expect = ImmutableList.of(expect1, expect2, expect3);
        boolean equal = ListUtil.equal(expect, lists);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0049_GroupAnagrams.Solution solution = new _0049_GroupAnagrams().new Solution();
        String[] input = new String[]{""};
        List<List<String>> lists = solution.groupAnagrams(input);
        List<String> expect1 = ImmutableList.of("");
        List<List<String>> expect = ImmutableList.of(expect1);
        boolean equal = ListUtil.equal(expect, lists);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0049_GroupAnagrams.Solution solution = new _0049_GroupAnagrams().new Solution();
        String[] input = new String[]{"a"};
        List<List<String>> lists = solution.groupAnagrams(input);
        List<String> expect1 = ImmutableList.of("a");
        List<List<String>> expect = ImmutableList.of(expect1);
        boolean equal = ListUtil.equal(expect, lists);
        Assert.assertTrue(equal);
    }
}