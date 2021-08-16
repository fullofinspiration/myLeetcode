package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0146_LRUCacheTest {

    @Test
    public void test00() {
        _0146_LRUCache lruCache = new _0146_LRUCache();
        _0146_LRUCache.LRUCache cache = lruCache.new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int firstValue = cache.get(1);
        assertEquals(1, firstValue);
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    public void test01() {
        _0146_LRUCache lruCache = new _0146_LRUCache();
        _0146_LRUCache.LRUCache cache = lruCache.new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }
}