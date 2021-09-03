package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class _0093_RestoreIpAddressTest {

    @Test
    public void test00() {
        _0093_RestoreIpAddress.Solution solution = new _0093_RestoreIpAddress().new Solution();
        List<String> rst = solution.restoreIpAddresses("25525511135");
        ImmutableList<String> expect = ImmutableList.of("255.255.11.135", "255.255.111.35");
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0093_RestoreIpAddress.Solution solution = new _0093_RestoreIpAddress().new Solution();
        List<String> rst = solution.restoreIpAddresses("0000");
        ImmutableList<String> expect = ImmutableList.of("0.0.0.0");
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0093_RestoreIpAddress.Solution solution = new _0093_RestoreIpAddress().new Solution();
        List<String> rst = solution.restoreIpAddresses("010010");
        ImmutableList<String> expect = ImmutableList.of("0.10.0.10","0.100.1.0");
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test03() {
        _0093_RestoreIpAddress.Solution solution = new _0093_RestoreIpAddress().new Solution();
        List<String> rst = solution.restoreIpAddresses("101023");
        ImmutableList<String> expect = ImmutableList.of("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3");
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }



}