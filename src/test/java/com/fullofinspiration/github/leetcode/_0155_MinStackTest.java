package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0155_MinStackTest {
    @Test
    public void test00() {
        _0155_MinStack.MinStack minStack = new _0155_MinStack().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        assertEquals(-3, min);
        minStack.pop();
        int top = minStack.top();
        assertEquals(0, top);
        int min1 = minStack.getMin();
        assertEquals(-2, min1);
    }

    @Test
    public void test01() {
        _0155_MinStack.MinStack minStack = new _0155_MinStack().new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        int top1 = minStack.top();
        assertEquals(2147483647, top1);
        minStack.pop();
        int min2 = minStack.getMin();
        assertEquals(2147483646, min2);
        minStack.pop();
        int min3 = minStack.getMin();
        assertEquals(2147483646, min3);
        minStack.pop();
        minStack.push(2147483647);
        int top = minStack.top();
        assertEquals(2147483647, top);
        assertEquals(2147483647, minStack.getMin());
    }

}