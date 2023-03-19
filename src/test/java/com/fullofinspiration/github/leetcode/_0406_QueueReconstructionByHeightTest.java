package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ArrayUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0406_QueueReconstructionByHeightTest extends TestCase {
    @Test
    public void test00() {
        _0406_QueueReconstructionByHeight.Solution solution = new _0406_QueueReconstructionByHeight().new Solution();
        int[][] actual = solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        int[][] expect = new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0406_QueueReconstructionByHeight.Solution solution = new _0406_QueueReconstructionByHeight().new Solution();
        int[][] actual = solution.reconstructQueue(new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}});
        int[][] expect = new int[][]{{4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

}