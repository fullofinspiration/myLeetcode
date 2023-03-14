package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class _0232_ImplementQueueUsingStacksTest {
    @Test
    public void test00() {
        _0232_ImplementQueueUsingStacks.MyQueue myQueue = new _0232_ImplementQueueUsingStacks().new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int peek = myQueue.peek();
        assertEquals(1, peek);
        int pop = myQueue.pop();
        assertEquals(1, pop);
        assertFalse(myQueue.empty());
    }

}