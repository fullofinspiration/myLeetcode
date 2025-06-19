package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0208_TrieTest {
    @Test
    public void test00() {
        _0208_Trie.Trie trie = new _0208_Trie().new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");// 返回 True
        Assert.assertTrue(apple);
        boolean app = trie.search("app");// 返回 False
        Assert.assertFalse(app);
        boolean app1 = trie.startsWith("app");// 返回 True
        Assert.assertTrue(app1);
        trie.insert("app");
        boolean app2 = trie.search("app");// 返回 True
        Assert.assertTrue(app2);
    }


}