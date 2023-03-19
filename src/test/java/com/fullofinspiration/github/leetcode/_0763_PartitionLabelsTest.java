package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0763_PartitionLabelsTest extends TestCase {
    @Test
    public void test00() {
        _0763_PartitionLabels.Solution solution = new _0763_PartitionLabels().new Solution();
        List<Integer> rst = solution.partitionLabels("ababcbacadefegdehijhklij");
        List<Integer> expect = Arrays.asList(9, 7, 8);
        boolean b = ListUtil.equalV2(expect, rst);
        Assert.assertTrue(b);
    }

    @Test
    public void test01() {
        _0763_PartitionLabels.Solution solution = new _0763_PartitionLabels().new Solution();
        List<Integer> rst = solution.partitionLabels("eccbbbbdec");
        List<Integer> expect = Collections.singletonList(10);
        boolean b = ListUtil.equalV2(expect, rst);
        Assert.assertTrue(b);
    }
}