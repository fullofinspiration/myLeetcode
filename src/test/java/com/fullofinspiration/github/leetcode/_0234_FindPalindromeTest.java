package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0234_FindPalindromeTest {
    @Test
    public void test00() {
        _0234_FindPalindrome.Solution solution = new _0234_FindPalindrome().new Solution();
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 2, 1});
        boolean palindrome = solution.isPalindrome(listNode);
        Assert.assertTrue(palindrome);
    }

    @Test
    public void test01() {
        _0234_FindPalindrome.Solution solution = new _0234_FindPalindrome().new Solution();
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2});
        boolean palindrome = solution.isPalindrome(listNode);
        Assert.assertFalse(palindrome);
    }

    @Test
    public void test02() {
        _0234_FindPalindrome.Solution solution = new _0234_FindPalindrome().new Solution();
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 2, 1});
        boolean palindrome = solution.isPalindrome(listNode);
        Assert.assertTrue(palindrome);
    }

    @Test
    public void test03() {
        _0234_FindPalindrome.Solution solution = new _0234_FindPalindrome().new Solution();
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 1, 2, 1});
        boolean palindrome = solution.isPalindrome(listNode);
        Assert.assertFalse(palindrome);
    }

}