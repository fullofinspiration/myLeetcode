package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class _0049_GroupAnaGramTest extends TestCase {
    @Test
    @Ignore
    public void test00() {
        _0049_GroupAnaGram.Solution solution = new _0049_GroupAnaGram().new Solution();
        String[] inputs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> actual = solution.groupAnagrams(inputs);
        List<List<String>> expect = asList(asList("bat"), asList("nat", "tan"), asList("ate", "eat", "tea"));
        boolean equal = ListUtil.equalV2(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0049_GroupAnaGram.Solution solution = new _0049_GroupAnaGram().new Solution();
        String[] inputs = new String[]{};
        List<List<String>> actual = solution.groupAnagrams(inputs);
        List<List<String>> expect = Collections.emptyList();
        boolean equal = ListUtil.equalV2(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0049_GroupAnaGram.Solution solution = new _0049_GroupAnaGram().new Solution();
        String[] inputs = new String[]{"bat"};
        List<List<String>> actual = solution.groupAnagrams(inputs);
        List<List<String>> expect = asList(asList("bat"));
        boolean equal = ListUtil.equalV2(expect, actual);
        Assert.assertTrue(equal);
    }

}