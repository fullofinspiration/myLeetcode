package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0225_ImplementStackUsingQueueTest extends TestCase {
    @Test
    public void test00() {
        _0225_ImplementStackUsingQueue.MyStack stack = new _0225_ImplementStackUsingQueue().new MyStack();
        stack.push(1);
        stack.push(2);
        int top = stack.top();
        Assert.assertEquals(2, top);

        stack.pop();
        top = stack.top();
        Assert.assertEquals(1, top);
    }

}