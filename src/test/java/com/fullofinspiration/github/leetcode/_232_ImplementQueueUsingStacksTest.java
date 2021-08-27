package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class _232_ImplementQueueUsingStacksTest {
    @Test
    public void test00() {
        _232_ImplementQueueUsingStacks.MyQueue myQueue = new _232_ImplementQueueUsingStacks().new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int peek = myQueue.peek();
        assertEquals(1, peek);
        int pop = myQueue.pop();
        assertEquals(1, pop);
        assertFalse(myQueue.empty());
    }

}