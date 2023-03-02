package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
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

    @Test
    public void test02() {
        _0146_LRUCache lruCache = new _0146_LRUCache();
        _0146_LRUCache.LRUCache cache = lruCache.new LRUCache(3);
        for (int i = 0; i < 100; i++) {
            cache.put(i, i);
        }
        assertEquals(-1, cache.get(1));
        assertEquals(97, cache.get(97));
        assertEquals(99, cache.get(99));
        assertEquals(-1, cache.get(96));
    }

    @Test
    public void test03() {
        _0146_LRUCache lruCache = new _0146_LRUCache();
        _0146_LRUCache.LRUCache cache = lruCache.new LRUCache(3);
        for (int i = 0; i < 2; i++) {
            cache.put(i, i);
        }
        assertEquals(-1, cache.get(2));
        cache.put(2, 2);
        assertEquals(2, cache.get(2));
        cache.put(3, 3);
        assertEquals(-1, cache.get(0));
        assertEquals(3, cache.get(3));
        assertEquals(2, cache.get(2));
        assertEquals(1, cache.get(1));
    }

    @Test
    public void test04() {
        _0146_LRUCache.LRUCache cache =  new _0146_LRUCache().new LRUCache(10);
        handleValue(cache);
    }

    @Test
    public void test05() {
        _0146_LRUCache.LRUCache cache =  new _0146_LRUCache().new LRUCache(10);
        cache.put(10,10);
        cache.put(3,10);
        cache.put(6,10);
        System.out.println(cache.debugPrint());
        cache.put(10,10);
        System.out.println(cache.debugPrint());
    }
    private void handleValue(_0146_LRUCache.LRUCache cache) {
        String[] input1 = new String[]{"put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
        int[][] input2 = new int[][]{{10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10}, {13}, {2, 19}, {2}, {3}, {5, 25}, {8}, {9, 22}, {5, 5}, {1, 30}, {11}, {9, 12}, {7}, {5}, {8}, {9}, {4, 30}, {9, 3}, {9}, {10}, {10}, {6, 14}, {3, 1}, {3}, {10, 11}, {8}, {2, 14}, {1}, {5}, {4}, {11, 4}, {12, 24}, {5, 18}, {13}, {7, 23}, {8}, {12}, {3, 27}, {2, 12}, {5}, {2, 9}, {13, 4}, {8, 18}, {1, 7}, {6}, {9, 29}, {8, 21}, {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22}, {11, 26}, {8, 17}, {9, 29}, {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4}, {1}, {10}, {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26}, {8}, {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12}, {9, 19}, {2, 15}, {3, 16}, {1}, {12, 17}, {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28}, {1}, {2, 2}, {7, 4}, {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}};
        Integer[] output = new Integer[]{ null, null, null, null, null, -1, null, 19, 17, null, -1, null, null, null, -1, null, -1, 5, -1, 12, null, null, 3, 5, 5, null, null, 1, null, -1, null, 30, 5, 30, null, null, null, -1, null, -1, 24, null, null, 18, null, null, null, null, -1, null, null, 18, null, null, -1, null, null, null, null, null, 18, null, null, -1, null, 4, 29, 30, null, 12, -1, null, null, null, null, 29, null, null, null, null, 17, 22, 18, null, null, null, -1, null, null, null, 20, null, null, null, -1, 18, 18, null, null, null, null, 20, null, null, null, null, null, null, null};

        for (int i = 0; i < input1.length; i++) {
            switch (input1[i]) {
                case "put":
                    cache.put(input2[i][0], input2[i][1]);
                    System.out.println(cache.debugPrint());
                    break;
                case "get":
                    int val = cache.get(input2[i][0]);
                    if (output[i] !=val) {
                        System.out.println("cur val is: " + input2[i][0]);
                        System.out.println(cache.debugPrint());
                    }
                    Assert.assertEquals(output[i].intValue(), val);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

    }
}