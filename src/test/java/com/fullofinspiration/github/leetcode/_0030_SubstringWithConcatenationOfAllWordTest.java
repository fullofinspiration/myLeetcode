package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0030_SubstringWithConcatenationOfAllWordTest extends TestCase {
    @Test
    public void test00() {
        _0030_SubstringWithConcatenationOfAllWord.Solution solution = new _0030_SubstringWithConcatenationOfAllWord().new Solution();
        List<Integer> rst = solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar" });
        List<Integer> expect  = Arrays.asList(0,9);
        boolean equal = ListUtil.equal(rst, expect);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0030_SubstringWithConcatenationOfAllWord.Solution solution = new _0030_SubstringWithConcatenationOfAllWord().new Solution();
        List<Integer> rst = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
        List<Integer> expect  = Collections.emptyList();
        boolean equal = ListUtil.equal(rst, expect);
        Assert.assertTrue(equal);
    }
    @Test
    public void test02() {
        _0030_SubstringWithConcatenationOfAllWord.Solution solution = new _0030_SubstringWithConcatenationOfAllWord().new Solution();
        List<Integer> rst = solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        List<Integer> expect  = Arrays.asList(6,9,12);
        boolean equal = ListUtil.equal(rst, expect);
        Assert.assertTrue(equal);
    }
    public void test03() {
        _0030_SubstringWithConcatenationOfAllWord.Solution solution = new _0030_SubstringWithConcatenationOfAllWord().new Solution();
        List<Integer> rst = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        List<Integer> expect  = Arrays.asList(8);
        boolean equal = ListUtil.equal( expect,rst);
        Assert.assertTrue(equal);
    }

}