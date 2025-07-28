package com.fullofinspiration.github.interview;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class KthReverseTest extends TestCase {

    @Test
    public void test00() {
        KthReverse.Solution solution = new KthReverse().new Solution();
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 3});
        ListNode ret = solution.reverseK(listNode, 1, 2);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{2,1,3});
        boolean equal = ListNodeUtil.equal(expect, ret);
        Assert.assertTrue(equal);
    }
}